package com.osc.leaderboard.github.service;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.osc.leaderboard.github.dtos.PullRequestResultDTO;
import com.osc.leaderboard.github.dtos.PullRequestSearchDTO;

@Service
public class GithubService {

    private static final List<String> PULL_REQUEST_SEARCH_PATH = new ArrayList<>(
            Arrays.asList("GithubSearchPullRequests1", "GithubSearchPullRequests2", "GithubSearchPullRequests3"));

    private final ObjectMapper objectMapper;

    private final Environment env;

    public GithubService(ObjectMapper objectMapper, Environment env) {
        this.objectMapper = objectMapper;
        this.env = env;
    }

    private JsonNode mockPullRequestSearchRequest(Integer page, Instant earliestDate) throws IOException {
        ClassPathResource resource = new ClassPathResource(PULL_REQUEST_SEARCH_PATH.get(page));
        File file = resource.getFile();
        JsonNode json = objectMapper.readTree(file);
        return json;
    }

    private JsonNode pullRequestSearchRequest(Integer page, Instant earliestDate) {
        throw new NotImplementedException();
    }

    private PullRequestSearchDTO processPullRequestSearchJson(JsonNode json) {
        Integer totalCount = json.get("total_count").asInt();
        Instant earliestDate = Instant.MAX;

        JsonNode itemsNode = json.get("items");
        List<PullRequestResultDTO> pullRequestResults = new ArrayList<>();
        for (JsonNode item : itemsNode) {
            JsonNode user = item.get("user");
            String username = user.get("login").asText();
            String avatarUrl = item.get("avatar_url").asText();

            String repoUrl = item.get("repository_url").asText();
            String repoName = repoUrl.substring(repoUrl.lastIndexOf("/") + 1);

            Instant mergedAt = Instant.parse(item.get("pull_request").get("merged_at").asText());
            earliestDate = earliestDate.compareTo(mergedAt) > 0 ? mergedAt : earliestDate;

            pullRequestResults.add(new PullRequestResultDTO(username, avatarUrl, repoName, mergedAt));
        }

        return new PullRequestSearchDTO(totalCount, pullRequestResults, earliestDate);
    }

    private Integer processPullRequestSearch(PullRequestSearchDTO pullRequestSearchDTO) {
        Integer totalCount = pullRequestSearchDTO.totalCount();

        // TODO: Call external services to populate database

        return totalCount;
    }

    public Integer fetchPullRequests() {
        String target = env.getProperty("TARGET");
        JsonNode currJson;
        Integer currPage = 1;
        Instant earliestDate = Instant.now().plus(1, ChronoUnit.DAYS);

        if (target == "prod") {
            currJson = pullRequestSearchRequest(currPage, earliestDate);
        } else {
            try {
                currJson = mockPullRequestSearchRequest(currPage, earliestDate);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        PullRequestSearchDTO pullRequestSearchDTO = processPullRequestSearchJson(currJson);
        Integer totalCount = pullRequestSearchDTO.totalCount();

        if (totalCount > 100) {
            Integer totalPages = (int) Math.ceil(totalCount / 100);
            for (int i = 2; i < totalPages + 1; ++i) {
                earliestDate = pullRequestSearchDTO.earliestDate();

                if (target == "prod") {
                    currJson = pullRequestSearchRequest(i, earliestDate);
                } else {
                    try {
                        currJson = mockPullRequestSearchRequest(i, earliestDate);
                    } catch (IOException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }

                pullRequestSearchDTO = processPullRequestSearchJson(currJson);
                totalCount = pullRequestSearchDTO.totalCount();

                if (i == 3 && target != "prod")
                    break;
            }
        }

        return totalCount;
    }

}

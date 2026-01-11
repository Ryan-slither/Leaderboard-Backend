package com.osc.leaderboard.pullrequest.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pullrequests")
public class PullRequest {

    @Id
    private String Id;

    private Instant mergedAt;

    // Many to One for Developers
    private List<String> developerIds = new ArrayList<>();

    // Many to One for Repos
    private List<String> repoIds = new ArrayList<>();

    public PullRequest() {
    }

    public PullRequest(String id, Instant mergedAt, List<String> developerIds, List<String> repoIds) {
        Id = id;
        this.mergedAt = mergedAt;
        this.developerIds = developerIds;
        this.repoIds = repoIds;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Instant getMergedAt() {
        return mergedAt;
    }

    public void setMergedAt(Instant mergedAt) {
        this.mergedAt = mergedAt;
    }

    public List<String> getDeveloperIds() {
        return developerIds;
    }

    public void setDeveloperIds(List<String> developerIds) {
        this.developerIds = developerIds;
    }

    public List<String> getRepoIds() {
        return repoIds;
    }

    public void setRepoIds(List<String> repoIds) {
        this.repoIds = repoIds;
    }

    @Override
    public String toString() {
        return "PullRequest [Id=" + Id + ", mergedAt=" + mergedAt + ", developerIds=" + developerIds + ", repoIds="
                + repoIds + "]";
    }

}
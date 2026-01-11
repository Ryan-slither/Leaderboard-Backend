package com.osc.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.osc.leaderboard.github.service.GithubService;

class GithubServiceTests extends BaseTest {

    public static final Integer TOTAL_COUNT = 1330;

    @Autowired
    private GithubService githubService;

    @Test
    void serviceNotNull() {
        assertNotNull(githubService);
    }

    @Test
    // Fetch pull requests runs without error for mocked api call and returns
    // correct total count
    void fetchPullRequestsTest() {
        Integer result = githubService.fetchPullRequests(Optional.empty());
        assertEquals(result, TOTAL_COUNT);
    }

}

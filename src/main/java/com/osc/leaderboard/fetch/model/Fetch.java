package com.osc.leaderboard.fetch.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Represents details for a search query of the Github API
@Document(collection = "fetches")
public class Fetch {

    @Id
    private String id;

    private Instant fetchedAt;

    // Total new pull requests since last fetch
    private Integer pullRequestCount;

    public Fetch() {
    }

    public Fetch(String id, Instant fetchedAt, Integer pullRequestCount) {
        this.id = id;
        this.fetchedAt = fetchedAt;
        this.pullRequestCount = pullRequestCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getFetchedAt() {
        return fetchedAt;
    }

    public void setFetchedAt(Instant fetchedAt) {
        this.fetchedAt = fetchedAt;
    }

    public Integer getPullRequestCount() {
        return pullRequestCount;
    }

    public void setPullRequestCount(Integer pullRequestCount) {
        this.pullRequestCount = pullRequestCount;
    }

    @Override
    public String toString() {
        return "Fetch [id=" + id + ", fetchedAt=" + fetchedAt + ", pullRequestCount=" + pullRequestCount + "]";
    }

}

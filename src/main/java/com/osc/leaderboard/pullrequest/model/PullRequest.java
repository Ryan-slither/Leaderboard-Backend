package com.osc.leaderboard.pullrequest.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pullrequests")
public class PullRequest {

    @Id
    private String Id;

    private Instant mergedAt;

    private String developerId;

    private String repoId;

    public PullRequest() {
    }

    public PullRequest(String id, Instant mergedAt, String developerId, String repoId) {
        Id = id;
        this.mergedAt = mergedAt;
        this.developerId = developerId;
        this.repoId = repoId;
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

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getRepoId() {
        return repoId;
    }

    public void setRepoId(String repoId) {
        this.repoId = repoId;
    }

    @Override
    public String toString() {
        return "PullRequest [Id=" + Id + ", mergedAt=" + mergedAt + ", developerId=" + developerId + ", repoId="
                + repoId + "]";
    }

}
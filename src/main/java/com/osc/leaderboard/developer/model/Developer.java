package com.osc.leaderboard.developer.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "developers")
public class Developer {

    @Id
    private String id;

    private String username;

    private String avatarUrl;

    // One to Many for Pull Requests
    private List<String> pullRequestIds = new ArrayList<>();

    // Many to Many for Repos
    private List<String> repoIds = new ArrayList<>();

    public Developer() {
    }

    public Developer(String id, String username, String avatarUrl, List<String> pullRequestIds, List<String> repoIds) {
        this.id = id;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.pullRequestIds = pullRequestIds;
        this.repoIds = repoIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getavatarUrl() {
        return avatarUrl;
    }

    public void setavatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public List<String> getPullRequestIds() {
        return pullRequestIds;
    }

    public void setPullRequestIds(List<String> pullRequestIds) {
        this.pullRequestIds = pullRequestIds;
    }

    public List<String> getRepoIds() {
        return repoIds;
    }

    public void setRepoIds(List<String> repoIds) {
        this.repoIds = repoIds;
    }

    @Override
    public String toString() {
        return "Developer [id=" + id + ", username=" + username + ", avatarUrl=" + avatarUrl + ", pullRequestIds="
                + pullRequestIds + ", repoIds=" + repoIds + "]";
    }

}

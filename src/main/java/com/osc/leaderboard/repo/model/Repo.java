package com.osc.leaderboard.repo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "repos")
public class Repo {

    @Id
    private String id;

    private String name;

    // One to Many for Pull Requests
    private List<String> pullRequestIds = new ArrayList<>();

    // Many to Many for Developers
    private List<String> developerIds = new ArrayList<>();

    public Repo() {
    }

    public Repo(String id, String name, List<String> pullRequestIds, List<String> developerIds) {
        this.id = id;
        this.name = name;
        this.pullRequestIds = pullRequestIds;
        this.developerIds = developerIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPullRequestIds() {
        return pullRequestIds;
    }

    public void setPullRequestIds(List<String> pullRequestIds) {
        this.pullRequestIds = pullRequestIds;
    }

    public List<String> getDeveloperIds() {
        return developerIds;
    }

    public void setDeveloperIds(List<String> developerIds) {
        this.developerIds = developerIds;
    }

    @Override
    public String toString() {
        return "Repo [id=" + id + ", name=" + name + ", pullRequestIds=" + pullRequestIds + ", developerIds="
                + developerIds + "]";
    }

}

package com.osc.leaderboard.repo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "repos")
public class Repo {

    @Id
    private String id;

    private String name;

    public Repo() {
    }

    public Repo(String id, String name, List<String> pullRequestIds, List<String> developerIds) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Repo [id=" + id + ", name=" + name + "]";
    }

}

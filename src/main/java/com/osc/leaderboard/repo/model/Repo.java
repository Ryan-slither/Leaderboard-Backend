package com.osc.leaderboard.repo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "repos")
public class Repo {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    public Repo() {
    }

    public Repo(String id, String name) {
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

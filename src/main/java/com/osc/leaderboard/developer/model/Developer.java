package com.osc.leaderboard.developer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "developers")
public class Developer {

    @Id
    private String id;

    private String username;

    private String avatarUrl;

    public Developer() {
    }

    public Developer(String id, String username, String avatarUrl) {
        this.id = id;
        this.username = username;
        this.avatarUrl = avatarUrl;
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

    @Override
    public String toString() {
        return "Developer [id=" + id + ", username=" + username + ", avatarUrl=" + avatarUrl + "]";
    }

}

package com.osc.leaderboard.github.dtos;

import java.time.Instant;

import jakarta.validation.constraints.NotNull;

public record PullRequestResultDTO(@NotNull String username, @NotNull String avatarUrl,
        @NotNull String repoName, @NotNull Instant mergedAt) {
}

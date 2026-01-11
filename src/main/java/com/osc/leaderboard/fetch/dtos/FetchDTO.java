package com.osc.leaderboard.fetch.dtos;

import java.time.Instant;

import jakarta.validation.constraints.NotNull;

public record FetchDTO(@NotNull String id, @NotNull Instant fetchedAt, @NotNull Integer pullRequestCount) {

}

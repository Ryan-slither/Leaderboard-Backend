package com.osc.leaderboard.github.dtos;

import java.time.Instant;
import java.util.List;

import jakarta.validation.constraints.NotNull;

public record PullRequestSearchDTO(@NotNull Integer totalCount,
        @NotNull List<PullRequestResultDTO> pullRequestResults, @NotNull Instant earliestDate) {
}
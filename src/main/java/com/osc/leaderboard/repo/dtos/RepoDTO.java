package com.osc.leaderboard.repo.dtos;

import jakarta.validation.constraints.NotNull;

public record RepoDTO(@NotNull String id, @NotNull String name) {
}

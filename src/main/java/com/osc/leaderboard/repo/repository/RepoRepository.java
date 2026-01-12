package com.osc.leaderboard.repo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.osc.leaderboard.repo.model.Repo;

public interface RepoRepository extends MongoRepository<Repo, String> {

    Optional<Repo> findByName(String name);

}

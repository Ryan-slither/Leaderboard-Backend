package com.osc.leaderboard.fetch.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.osc.leaderboard.fetch.model.Fetch;

public interface FetchRepository extends MongoRepository<Fetch, String> {

    List<Fetch> findByFetchedAtBetween(Instant start, Instant end);

    List<Fetch> findByFetchedAtLessThanEqual(Instant time);

    List<Fetch> findByFetchedAtGreaterThanEqual(Instant time);

    Optional<Fetch> findTopByOrderByFetchedAtDesc();

}

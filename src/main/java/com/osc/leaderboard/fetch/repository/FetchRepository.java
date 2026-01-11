package com.osc.leaderboard.fetch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.osc.leaderboard.fetch.model.Fetch;
import java.util.List;
import java.time.Instant;

public interface FetchRepository extends MongoRepository<Fetch, String> {

    List<Fetch> findByFetchedAtBetween(Instant start, Instant end);

}

package com.osc.leaderboard.pullrequest.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.osc.leaderboard.pullrequest.model.PullRequest;

public interface PullRequestRepository extends MongoRepository<PullRequest, String> {

    Optional<PullRequest> findByNodeId(String nodeId);

}

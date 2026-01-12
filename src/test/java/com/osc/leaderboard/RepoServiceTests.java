package com.osc.leaderboard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osc.leaderboard.fetch.service.FetchService;
import com.osc.leaderboard.repo.dtos.RepoDTO;
import com.osc.leaderboard.repo.service.RepoService;

public class RepoServiceTests extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(RepoServiceTests.class);

    @Autowired
    private RepoService repoService;

    @Autowired
    private FetchService fetchService;

    @Test
    void servicesNotNull() {
        assertNotNull(repoService);
        assertNotNull(fetchService);
    }

    @Test
    void createReposOnFetchTest() {
        fetchService.createFetch();

        HashSet<String> repoNames = new HashSet<>();

        List<RepoDTO> repoDTOs = repoService.findAllRepos();
        assertTrue(repoDTOs.size() > 0);
        repoDTOs.forEach(repo -> {
            assertFalse(repoNames.contains(repo.name()));
            repoNames.add(repo.name());
            logger.info(repo.name());
        });
    }
}

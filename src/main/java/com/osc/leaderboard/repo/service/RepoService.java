package com.osc.leaderboard.repo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.osc.leaderboard.repo.dtos.RepoDTO;
import com.osc.leaderboard.repo.model.Repo;
import com.osc.leaderboard.repo.repository.RepoRepository;

@Service
public class RepoService {

    private final RepoRepository repoRepository;

    public RepoService(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    public RepoDTO createRepo(String name) {
        Repo repoSaved = repoRepository.findByName(name).orElseGet(() -> {
            Repo repo = new Repo(null, name);
            return repoRepository.save(repo);
        });

        return repoToRepoDTO(repoSaved);
    }

    public List<RepoDTO> findAllRepos() {
        return repoRepository.findAll().stream().map(RepoService::repoToRepoDTO).toList();
    }

    public static RepoDTO repoToRepoDTO(Repo repo) {
        return new RepoDTO(repo.getId(), repo.getName());
    }

}

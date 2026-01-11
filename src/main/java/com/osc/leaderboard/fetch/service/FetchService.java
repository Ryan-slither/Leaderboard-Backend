package com.osc.leaderboard.fetch.service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.osc.leaderboard.fetch.dtos.FetchDTO;

@Service
public class FetchService {

    public FetchDTO createFetch() {
        throw new UnsupportedOperationException("Unimplemented method 'fetch'");
    }

    public List<FetchDTO> getFetchesByDate(Instant start, Instant end) {
        throw new UnsupportedOperationException("Unimplemented method 'getFetchesByDate'");
    }

}

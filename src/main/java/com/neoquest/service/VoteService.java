package com.neoquest.service;

import com.neoquest.dao.IVoteDao;
import com.neoquest.model.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoteService {
    private final IVoteDao voteDao;

    @Autowired
    public VoteService(IVoteDao voteDao) {
        this.voteDao = voteDao;
    }

    public void vote(Vote vote) {
        voteDao.create(vote);
    }
}

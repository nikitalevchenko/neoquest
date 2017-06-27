package com.neoquest.dao;

import com.neoquest.model.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class VoteDao implements IVoteDao {

    private static final String SQL_CREATE_VOTE =
            "INSERT INTO public.vote("
                    + DbFields.REPORT_ID
                    + ", "
                    + DbFields.DEVICE_ID
                    + ") VALUES (:reportId, :deviceId);";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public VoteDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Vote vote) {
        final HashMap namedParameters = new HashMap();
        namedParameters.put("reportId", vote.getReportId());
        namedParameters.put("deviceId", vote.getDeviceId());
        jdbcTemplate.update(SQL_CREATE_VOTE, namedParameters);
    }
}

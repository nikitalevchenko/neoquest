package com.neoquest.dao;

import com.neoquest.exception.ReportsListIsEmptyException;
import com.neoquest.mapper.ReportMapper;
import com.neoquest.mapper.VotesCountMapper;
import com.neoquest.model.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ReportDao implements IReportDao {

    private static final String SQL_GET_REPORTS_LIST =
            "select * from public.\""
                    + DbFields.Tables.REPORT
                    + "\";";

    private static final String SQL_GET_REPORT_BY_HASH =
            "select * from public.\""
                    + DbFields.Tables.REPORT
                    + "\" where "
                    + DbFields.HASH_VALUE
                    + " = :hashValue";


    private static final String SQL_GET_VOTES_COUNT =
            "select count(*) from public."
                    + DbFields.Tables.VOTE
                    + " where " + DbFields.REPORT_ID
                    + " = :reportId;";

    private final ReportMapper reportMapper;
    private final VotesCountMapper votesCountMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ReportDao(ReportMapper reportMapper, VotesCountMapper votesCountMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.reportMapper = reportMapper;
        this.votesCountMapper = votesCountMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Report> readAll() {
        final HashMap namedParameters = new HashMap();
        final List<Report> reports = jdbcTemplate.query(
                SQL_GET_REPORTS_LIST,
                reportMapper
        );
        if (reports.isEmpty()) {
            throw new ReportsListIsEmptyException();
        }

        for (Report report : reports) {
            namedParameters.clear();
            namedParameters.put("reportId", report.getId());
            report.setVotesCount(jdbcTemplate.queryForObject(SQL_GET_VOTES_COUNT,
                    namedParameters,
                    votesCountMapper));
        }

        return reports;
    }

    @Override
    public Report readByHash(String hashValue) {
        return jdbcTemplate.queryForObject(
                SQL_GET_REPORT_BY_HASH,
                new HashMap() {{
                    put("hashValue", hashValue);
                }},
                reportMapper
        );
    }

}

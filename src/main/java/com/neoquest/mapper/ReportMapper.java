package com.neoquest.mapper;

import com.neoquest.dao.DbFields;
import com.neoquest.model.entity.Report;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ReportMapper implements RowMapper<Report> {
    @Override
    public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Report report = new Report();

        report.setId(rs.getInt(DbFields.ID));
        report.setName(rs.getString(DbFields.NAME));
        report.setAuthor(rs.getString(DbFields.AUTHOR));
        report.setDescription(rs.getString(DbFields.DESCRIPTION));
        report.setHashValue(rs.getString(DbFields.HASH_VALUE));

        return report;
    }
}

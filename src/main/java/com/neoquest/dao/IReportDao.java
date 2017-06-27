package com.neoquest.dao;

import com.neoquest.model.entity.Report;

import java.util.List;

public interface IReportDao {
    List<Report> readAll();
    Report readByHash(String hashValue);
}

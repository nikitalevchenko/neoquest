package com.neoquest.service;

import com.neoquest.dao.IReportDao;
import com.neoquest.model.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportService {
    private final IReportDao reportDao;

    @Autowired
    public ReportService(IReportDao reportDao) {
        this.reportDao = reportDao;
    }

    public List<Report> getReportsList() {
        return reportDao.readAll();
    }

    public Report getReport(String hashValue) {
        return reportDao.readByHash(hashValue);
    }
}

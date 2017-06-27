package com.neoquest.model.entity;

public class Vote {
    private int    reportId;
    private String deviceId;

    public Vote(int reportId, String deviceId) {
        this.reportId = reportId;
        this.deviceId = deviceId;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}

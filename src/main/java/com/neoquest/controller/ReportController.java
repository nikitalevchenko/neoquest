package com.neoquest.controller;

import com.neoquest.crypt.DeviceGenerator;
import com.neoquest.model.entity.Device;
import com.neoquest.model.request.ReportsRequest;
import com.neoquest.model.response.ReportsResponse;
import com.neoquest.service.DeviceService;
import com.neoquest.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/getReportsList", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ReportController {

    private final ReportService reportService;
    private final DeviceService deviceService;

    @Autowired
    public ReportController(ReportService reportService, DeviceService deviceService) {
        this.reportService = reportService;
        this.deviceService = deviceService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ReportsResponse getReportsList(@RequestBody ReportsRequest reportsRequest) {
        Device device = null;

        if (deviceService.isExist(reportsRequest.getDeviceId())) {
            device = deviceService.read(reportsRequest.getDeviceId());
        } else {
            device = new DeviceGenerator().getDevice(reportsRequest.getDeviceId());
            deviceService.create(device);
        }

        final ReportsResponse.Response response = new ReportsResponse.Response();

        response.setReports(reportService.getReportsList());
        response.setK(device.getK());
        response.setPublicKey(device.getPublicKey());

        return new ReportsResponse(response);
    }
}

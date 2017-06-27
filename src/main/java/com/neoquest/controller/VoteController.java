package com.neoquest.controller;

import com.neoquest.crypt.Decrypter;
import com.neoquest.model.entity.Device;
import com.neoquest.model.entity.Report;
import com.neoquest.model.entity.Vote;
import com.neoquest.model.request.VoteRequest;
import com.neoquest.model.response.Response;
import com.neoquest.service.DeviceService;
import com.neoquest.service.ReportService;
import com.neoquest.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/vote", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class VoteController {

    private final VoteService voteService;
    private final ReportService reportService;
    private final DeviceService deviceService;

    @Autowired
    public VoteController(VoteService voteService, ReportService reportService, DeviceService deviceService) {
        this.voteService   = voteService;
        this.reportService = reportService;
        this.deviceService = deviceService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Response vote(@RequestBody VoteRequest voteRequest) {
        final Device device = deviceService.read(voteRequest.getDeviceId());
        final Report report = reportService.getReport(new Decrypter().getHashValue(device, voteRequest));
        voteService.vote(new Vote(report.getId(), device.getDeviceId()));
        return new Response(true);
    }
}

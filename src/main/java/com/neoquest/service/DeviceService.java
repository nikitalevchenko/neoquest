package com.neoquest.service;

import com.neoquest.dao.IDeviceDao;
import com.neoquest.model.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeviceService {
    private final IDeviceDao deviceDao;

    @Autowired
    public DeviceService(IDeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    public void create(Device device) {
        deviceDao.create(device);
    }

    public Device read(String deviceId) {
        return deviceDao.read(deviceId);
    }

    public boolean isExist(String deviceId) {
        return deviceDao.isExist(deviceId);
    }
}

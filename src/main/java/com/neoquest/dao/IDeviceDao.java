package com.neoquest.dao;

import com.neoquest.model.entity.Device;

public interface IDeviceDao {
    Device read(String deviceId);
    void create(Device device);
    boolean isExist(String deviceId);
}

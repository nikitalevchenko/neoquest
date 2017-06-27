package com.neoquest.crypt;

import com.neoquest.model.entity.Device;

public class DeviceGenerator {
    public Device getDevice(String deviceId) {
        final Device device = new Device();
        device.setDeviceId(deviceId);

        // TODO: 26.06.17
        device.setPrivateKey("private key");
        device.setPublicKey("public key");
        device.setK("kkk");

        return device;
    }
}

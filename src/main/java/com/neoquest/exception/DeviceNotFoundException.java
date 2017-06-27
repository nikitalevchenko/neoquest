package com.neoquest.exception;

public class DeviceNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Device not found";
    }
}
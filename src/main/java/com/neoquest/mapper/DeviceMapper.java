package com.neoquest.mapper;

import com.neoquest.dao.DbFields;
import com.neoquest.model.entity.Device;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DeviceMapper implements RowMapper<Device> {
    @Override
    public Device mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Device device = new Device();

        device.setDeviceId(rs.getString(DbFields.DEVICE_ID));
        device.setPublicKey(rs.getString(DbFields.PUBLIC_KEY));
        device.setPrivateKey(rs.getString(DbFields.PRIVATE_KEY));
        device.setK(rs.getString(DbFields.K));

        return device;
    }
}

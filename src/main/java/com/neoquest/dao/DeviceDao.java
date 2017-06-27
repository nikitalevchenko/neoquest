package com.neoquest.dao;

import com.neoquest.mapper.DeviceCountMapper;
import com.neoquest.mapper.DeviceMapper;
import com.neoquest.model.entity.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class DeviceDao implements IDeviceDao {

    private static final String SQL_GET_DEVICE =
            "select * from public.\""
                    + DbFields.Tables.DEVICE
                    + "\" where "
                    + DbFields.DEVICE_ID
                    + " = :deviceId;";

    private static final String SQL_CREATE_DEVICE =
            "INSERT INTO public."
                    + DbFields.Tables.DEVICE
                    + "("
                    + DbFields.DEVICE_ID
                    + ", "
                    + DbFields.PUBLIC_KEY
                    + ", "
                    + DbFields.PRIVATE_KEY
                    + ", "
                    + DbFields.K
                    + ") VALUES (:deviceId, :publicKey, :privateKey, :k);";

    private static final String SQL_GET_DEVICES_COUNT =
            "select count(*) from public."
                    + DbFields.Tables.DEVICE
                    + " where "
                    + DbFields.DEVICE_ID
                    + " = :deviceId;";


    private final DeviceMapper               deviceMapper;
    private final DeviceCountMapper          deviceCountMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public DeviceDao(DeviceMapper deviceMapper, DeviceCountMapper deviceCountMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.deviceMapper      = deviceMapper;
        this.deviceCountMapper = deviceCountMapper;
        this.jdbcTemplate      = jdbcTemplate;
    }

    @Override
    public Device read(String deviceId) {
        return jdbcTemplate.queryForObject(
                SQL_GET_DEVICE,
                new HashMap() {{
                    put("deviceId", deviceId);
                }},
                deviceMapper
        );
    }

    @Override
    public void create(Device device) {
        jdbcTemplate.update(SQL_CREATE_DEVICE, new HashMap() {{
            put("deviceId", device.getDeviceId());
            put("publicKey", device.getPublicKey());
            put("privateKey", device.getPrivateKey());
            put("k", device.getK());
        }});
    }

    @Override
    public boolean isExist(String deviceId) {
        return jdbcTemplate.queryForObject(SQL_GET_DEVICES_COUNT,
                new HashMap() {{
                    put("deviceId", deviceId);
                }},
                deviceCountMapper) > 0;
    }

}

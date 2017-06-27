package com.neoquest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mainPool")
public class ConnectionSettings {

    private static int DEFAULT_MAX_POOL_SIZE = 5;

    private String jdbcDriver = "org.postgresql.Driver";
    private String jdbcString = "jdbc:postgresql://localhost:5432/neoquest";
    private String jdbcUser = "postgres";
    private String jdbcPassword = "8641";
    private int jdbcMaxPoolSize = 100;

    public static int getDefaultMaxPoolSize() {
        return DEFAULT_MAX_POOL_SIZE;
    }

    public static void setDefaultMaxPoolSize(int defaultMaxPoolSize) {
        DEFAULT_MAX_POOL_SIZE = defaultMaxPoolSize;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcString() {
        return jdbcString;
    }

    public void setJdbcString(String jdbcString) {
        this.jdbcString = jdbcString;
    }

    public String getJdbcUser() {
        return jdbcUser;
    }

    public void setJdbcUser(String jdbcUser) {
        this.jdbcUser = jdbcUser;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public int getJdbcMaxPoolSize() {
        return jdbcMaxPoolSize;
    }

    public void setJdbcMaxPoolSize(int jdbcMaxPoolSize) {
        this.jdbcMaxPoolSize = jdbcMaxPoolSize;
    }
}

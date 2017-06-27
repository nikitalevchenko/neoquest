package com.neoquest.dao;

public class DbFields {
    public static final String ID          = "id";
    public static final String NAME        = "name";
    public static final String AUTHOR      = "author";
    public static final String DESCRIPTION = "description";
    public static final String REPORT_ID   = "report_id";
    public static final String DEVICE_ID   = "device_id";
    public static final String COUNT       = "count";
    public static final String HASH_VALUE  = "hash_value";
    public static final String PUBLIC_KEY  = "public_key";
    public static final String PRIVATE_KEY = "private_key";
    public static final String K           = "k";

    public static class Tables {
        public static final String REPORT = "report";
        public static final String VOTE   = "vote";
        public static final String DEVICE = "device";
    }
}

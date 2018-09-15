package com.wj5633.pms.util;

/**
 * @author wj
 * @create 2018-09-14 22:39
 **/
public class RedisKeyUtil {

    public static String getKeyWithColumn(String tableName, String majorKey, String majorKeyValue, String column) {
        return String.join(":", tableName, majorKey, majorKeyValue, column);
    }

    public static String getKey(String tableName, String majorKey, String majorKeyValue) {
        return String.join(":", tableName, majorKey, majorKeyValue, "");
    }
}

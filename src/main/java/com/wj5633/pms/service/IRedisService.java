package com.wj5633.pms.service;

/**
 * @author wj
 * @create 2018-09-14 23:24
 **/
public interface IRedisService {
    boolean set(String key, String value);

    boolean set(String key, String value, Long expire);

    Object get(String key);

    boolean exists(String key);

    boolean remove(String key);

    void remove(String... keys);
}

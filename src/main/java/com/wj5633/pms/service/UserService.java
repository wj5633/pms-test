package com.wj5633.pms.service;

import com.wj5633.pms.model.User;

import java.util.List;

/**
 * @author wj
 * @create 2018-09-13 12:25
 **/

public interface UserService {
    List<User> findAll();

    User findUserById(long userId);

    void deleteUser(long userId);

    User saveUser(User user);

    User updateUser(long userId, User user);
}

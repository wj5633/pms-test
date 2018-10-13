package com.wj5633.pms.service.impl;

import com.wj5633.pms.model.User;
import com.wj5633.pms.repository.UserRepository;
import com.wj5633.pms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author wj
 * @create 2018-09-13 12:27
 **/
@Service
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long userId) {
        Optional<User> optional = userRepository.findById(userId);
        return optional.orElse(null);
    }

    @Override
    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User updateUser(long userId, User user) {
        User resource = findUserById(userId);
        if (!StringUtils.isEmpty(user.getName())) {
            resource.setName(user.getName());
        }
        if (!StringUtils.isEmpty(user.getAge())) {
            resource.setAge(user.getAge());
        }
        return userRepository.saveAndFlush(resource);
    }
}

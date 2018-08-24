package com.wj5633.pms.controller;

import com.wj5633.pms.model.User;
import com.wj5633.pms.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wj
 * @create 2018-08-21 13:35
 **/

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/user")
    public User create(@RequestBody User userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setAge(userForm.getAge());
        return userRepository.saveAndFlush(user);
    }

    @GetMapping("/user")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public User get(@PathVariable long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @PutMapping("/user/{userId}")
    public User update(@PathVariable long userId, @RequestBody User userForm) {
        User user = userRepository.getOne(userId);
        if (!StringUtils.isEmpty(userForm.getName())) {
            user.setName(userForm.getName());
        }
        if (!StringUtils.isEmpty(userForm.getAge())) {
            user.setAge(userForm.getAge());
        }
        return userRepository.saveAndFlush(user);
    }

    @DeleteMapping("/user/{userId}")
    public void delete(@PathVariable long userId) {
        userRepository.deleteById(userId);
    }
}

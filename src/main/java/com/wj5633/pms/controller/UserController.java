package com.wj5633.pms.controller;

import com.wj5633.pms.model.User;
import com.wj5633.pms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wj
 * @create 2018-08-21 13:35
 **/
@Api
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping
    @ResponseBody
    public User create(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @ApiOperation(value = "用户列表", notes = "用户列表")
    @GetMapping
    @ResponseBody
    public List<User> list() {
        return userService.findAll();
    }

    @ApiOperation(value = "获取用户信息", notes = "根据 userId 获取用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{userId}")
    @ResponseBody
    public User get(@PathVariable long userId) {
        return userService.findUserById(userId);
    }

    @ApiOperation(value = "更新用户信息", notes = "根据 userId 更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @PutMapping("/{userId}")
    @ResponseBody
    public User update(@PathVariable long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @ApiOperation(value = "删除用户", notes = "根据 userId 删除指定用户")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{userId}")
    @ResponseBody
    public void delete(@PathVariable long userId) {
        userService.deleteUser(userId);
    }
}

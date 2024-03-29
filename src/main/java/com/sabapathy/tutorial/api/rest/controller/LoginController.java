package com.sabapathy.tutorial.api.rest.controller;

import com.sabapathy.tutorial.api.rest.mapper.UserMapper;
import com.sabapathy.tutorial.api.rest.model.LoginRequest;
import com.sabapathy.tutorial.api.rest.model.UserRequest;
import com.sabapathy.tutorial.api.rest.model.UserResponse;
import com.sabapathy.tutorial.service.api.LoginService;
import com.sabapathy.tutorial.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j

@RestController
@RequestMapping("/api/rest/home")
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public UserResponse register(@RequestBody UserRequest userRequest) {
        return userMapper.toUserResponse(userService.addUser(userMapper.toUser(userRequest)));
    }

    @PostMapping("/login")
    @ResponseBody
    public UserResponse login(@RequestBody LoginRequest loginRequest) {
        return userMapper.toUserResponse(loginService.authUser(userMapper.toUser(loginRequest)));
    }
}

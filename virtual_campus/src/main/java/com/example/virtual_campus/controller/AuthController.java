package com.example.virtual_campus.controller;

import com.example.virtual_campus.model.User;
import com.example.virtual_campus.model.RoleName;
import com.example.virtual_campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * 用户认证控制器
 *
 * @author cui'jing'han
 * @since 2024/8/27 14:54
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user, @RequestParam RoleName role) {
        User registeredUser = userService.registerUser(user, role);
        return ResponseEntity.ok(registeredUser);
    }

    // 其他认证相关的API接口，例如登录和登出，通常涉及到Token的生成和验证
}
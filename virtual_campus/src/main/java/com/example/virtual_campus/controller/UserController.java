package com.example.virtual_campus.controller;

import com.example.virtual_campus.model.RoleName;
import com.example.virtual_campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * 用户管理控制器
 *
 * @author cui'jing'han
 * @since 2024/8/27 14:55
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{id}/assign-role")
    public ResponseEntity<?> assignRole(@PathVariable Long id, @RequestParam RoleName role) {
        userService.assignRoleToUser(id, role);
        return ResponseEntity.ok("Role assigned successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    // 可以添加更多用户相关的接口，如更新用户信息等
}
package com.example.virtual_campus.service;

import com.example.virtual_campus.model.Role;
import com.example.virtual_campus.model.RoleName;
import com.example.virtual_campus.model.User;
import com.example.virtual_campus.repository.RoleRepository;
import com.example.virtual_campus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
/**
 * 用户管理服务
 *
 * @author cui'jing'han
 * @since 2024/8/27 14:58
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user, RoleName roleName) {//注册用户
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        roles.add(userRole);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {//查找用户
        return userRepository.findByUsername(username);
    }

    public void deleteUser(Long userId) {//删除用户
        userRepository.deleteById(userId);
    }

    public void assignRoleToUser(Long userId, RoleName roleName) {//分配角色
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public void logoutUser(String username) {
        // 实现用户登出逻辑，通常由前端和会话管理处理
    }
}

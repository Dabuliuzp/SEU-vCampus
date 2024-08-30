package com.example.virtual_campus.model;

import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * 用户模型
 *
 * @author cui'jing'han
 * @since 2024/8/27 14:57
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String userId;  // 学号或工号

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

}
package com.example.virtual_campus.model;

import lombok.Data;
import javax.persistence.*;

/**
 * 角色模型
 *
 * @author cui'jing'han
 * @since 2024/8/27 14:56
 */
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName name;


}
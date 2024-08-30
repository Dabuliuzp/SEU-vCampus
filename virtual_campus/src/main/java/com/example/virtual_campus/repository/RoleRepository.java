package com.example.virtual_campus.repository;

import com.example.virtual_campus.model.Role;
import com.example.virtual_campus.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
/**
 * 角色数据仓库
 *
 * @author cui'jing'han
 * @since 2024/8/27 15:03
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}

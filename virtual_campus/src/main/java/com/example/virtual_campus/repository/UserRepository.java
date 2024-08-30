package com.example.virtual_campus.repository;

import com.example.virtual_campus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * 用户数据仓库
 *
 * @author cui'jing'han
 * @since 2024/8/27 15:02
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

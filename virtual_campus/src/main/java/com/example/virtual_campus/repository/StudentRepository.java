package com.example.virtual_campus.repository;
import com.example.virtual_campus.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 学生数据仓库
 *
 * @author cui'jing'han
 * @since 2024/8/27 15:03
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}

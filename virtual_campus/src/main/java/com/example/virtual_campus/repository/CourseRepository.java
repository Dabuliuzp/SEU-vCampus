package com.example.virtual_campus.repository;

import com.example.virtual_campus.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 课程数据仓库
 *
 * @author cui'jing'han
 * @since 2024/8/27 15:04
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

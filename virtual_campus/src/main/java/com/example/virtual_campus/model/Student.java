package com.example.virtual_campus.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;
/**
 * 学生模型
 *
 * @author cui'jing'han
 * @since 2024/8/27 14:57
 */
@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String studentId;  // 学号
    private String grade;
    private String major;
    private String status;  // 学籍状态：在读、休学、退学等

    @Setter
    @Getter
    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    // Lombok 自动生成的
    // e> getCourses() {
    //     return this.courses;
    // }
}

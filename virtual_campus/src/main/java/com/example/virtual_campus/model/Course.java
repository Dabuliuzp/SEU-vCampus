package com.example.virtual_campus.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * 课程模型
 *
 * @author cui'jing'han
 * @since 2024/8/27 14:58
 */
@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String teacher;
    private int credits;
    private String schedule;  // 课程安排

    private int capacity;  // 课程容量

    @Setter
    @Getter
    @ManyToMany(mappedBy = "courses")
    private Set<Student> enrolledStudents = new HashSet<>();

}

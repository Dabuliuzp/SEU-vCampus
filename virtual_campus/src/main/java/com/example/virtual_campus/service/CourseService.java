package com.example.virtual_campus.service;

import com.example.virtual_campus.model.Course;
import com.example.virtual_campus.model.Student;
import com.example.virtual_campus.repository.CourseRepository;
import com.example.virtual_campus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * 选课服务
 *
 * @author cui'jing'han
 * @since 2024/8/27 15:02
 */
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Course addCourse(Course course) {//新增课程
        return courseRepository.save(course);
    }

    public Optional<Course> updateCourse(Long id, Course courseDetails) {//更新课程
        return courseRepository.findById(id).map(course -> {
            course.setName(courseDetails.getName());
            course.setTeacher(courseDetails.getTeacher());
            course.setCredits(courseDetails.getCredits());
            course.setSchedule(courseDetails.getSchedule());
            course.setCapacity(courseDetails.getCapacity());
            return courseRepository.save(course);
        });
    }

    public List<Course> getAllCourses() {//获取所有课程信息
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {//获取单个课程信息
        return courseRepository.findById(id);
    }

    public void deleteCourse(Long id) {//删除课程信息
        courseRepository.deleteById(id);
    }

    public void enrollCourse(Long studentId, Long courseId) {//报名课程信息
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // 实现选课限制逻辑
        if (course.getCapacity() > course.getEnrolledStudents().size()) {
            student.getCourses().add(course);
            studentRepository.save(student);
        } else {
            throw new RuntimeException("Course is full");
        }
    }

    public void dropCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().remove(course);
        studentRepository.save(student);
    }

    public List<Course> getCoursesByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return new ArrayList<>(student.getCourses());
    }

    public List<Student> getStudentsByCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return new ArrayList<>(course.getEnrolledStudents());
    }
}

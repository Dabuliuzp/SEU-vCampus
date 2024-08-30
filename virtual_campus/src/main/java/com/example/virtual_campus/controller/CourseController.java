package com.example.virtual_campus.controller;

import com.example.virtual_campus.model.Course;
import com.example.virtual_campus.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 选课系统控制器
 *
 * @author cui'jing'han
 * @since 2024/8/27 14:56
 */
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course newCourse = courseService.addCourse(course);
        return ResponseEntity.ok(newCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseService.updateCourse(id, courseDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }

    @PostMapping("/{courseId}/enroll")
    public ResponseEntity<?> enrollCourse(@RequestParam Long studentId, @PathVariable Long courseId) {
        courseService.enrollCourse(studentId, courseId);
        return ResponseEntity.ok("Enrolled successfully");
    }

    @DeleteMapping("/{courseId}/drop")
    public ResponseEntity<?> dropCourse(@RequestParam Long studentId, @PathVariable Long courseId) {
        courseService.dropCourse(studentId, courseId);
        return ResponseEntity.ok("Dropped course successfully");
    }

    @GetMapping("/{courseId}/students")
    public List<?> getStudentsByCourse(@PathVariable Long courseId) {
        return courseService.getStudentsByCourse(courseId);
    }
}

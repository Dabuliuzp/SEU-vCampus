package com.example.virtual_campus.service;

import com.example.virtual_campus.model.Student;
import com.example.virtual_campus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * 学籍管理服务
 *
 * @author cui'jing'han
 * @since 2024/8/27 15:01
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {//新增学生
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student studentDetails) {//更新学生
        return studentRepository.findById(id).map(student -> {
            student.setName(studentDetails.getName());
            student.setStudentId(studentDetails.getStudentId());
            student.setGrade(studentDetails.getGrade());
            student.setMajor(studentDetails.getMajor());
            student.setStatus(studentDetails.getStatus());
            return studentRepository.save(student);
        });
    }

    public List<Student> getAllStudents() {//获取所有学生信息
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {//获取单个学生
        return studentRepository.findById(id);
    }

    public void deleteStudent(Long id) {//删除学生信息
        studentRepository.deleteById(id);
    }

    public void changeStudentStatus(Long studentId, String status) {//更改学生学籍
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setStatus(status);
        studentRepository.save(student);
    }
}

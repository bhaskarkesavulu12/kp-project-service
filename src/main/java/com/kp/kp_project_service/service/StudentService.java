package com.kp.kp_project_service.service;

import java.util.List;

import com.kp.kp_project_service.entity.Student;

public interface StudentService {
    
    public Student saveStudent(Student student);
    public Student updateStudent(Long id, Student student);
    public List<Student> list();
    public Student getStudentById(Long id);
    public void deleteStudentById(Long id);
    
}

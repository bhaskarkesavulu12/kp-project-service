package com.kp.kp_project_service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.kp_project_service.entity.Student;
import com.kp.kp_project_service.repository.StudentRepository;
import com.kp.kp_project_service.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository repository;

    @Override
    public Student saveStudent(Student student) {
        
        Student student2 = repository.save(student);
        LOGGER.info("Saved Student is :{}", student2);
        return student2;
        
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        
        Student student1 = null;
        Optional<Student> getStudentById;
        getStudentById = repository.findById(id);
        if(getStudentById.isPresent()){
            student1 = getStudentById.get();
        }else{
            LOGGER.error("Not Found");
        }
        student1.setId(student.getId());
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setMobile(student.getMobile());
        repository.save(student1);
        return student1;
    }

    @Override
    public List<Student> list() {
        
        List<Student> list = repository.findAll();
        LOGGER.info("List of Students are :{}", list);
        return list;
    }

    @Override
    public Student getStudentById(Long id) {
        
        Student student = null;
        Optional<Student> getStudentById;
        getStudentById = repository.findById(id);
        if(getStudentById.isPresent()){
            student = getStudentById.get();
        }else{
            LOGGER.error("Not Found");
        }
        LOGGER.info("Deleted Student By ID is :{}", student);
        return student;

    }

    @Override
    public void deleteStudentById(Long id) {
        
        LOGGER.info("Deleting Student By ID is :{}", + id);
        repository.deleteById(id);       
    }
    
}

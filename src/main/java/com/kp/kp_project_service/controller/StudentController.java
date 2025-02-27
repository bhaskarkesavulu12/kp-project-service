package com.kp.kp_project_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kp.kp_project_service.entity.Student;
import com.kp.kp_project_service.impl.StudentServiceImpl;

@RestController
@RequestMapping(value = "/api/kp")
public class StudentController {
    
    @Autowired
    private StudentServiceImpl service;

    @PostMapping(value = "/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){

        return new ResponseEntity<>(service.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Student>> list(){

        return new ResponseEntity<>(service.list(), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<Student> getStudentById(@RequestParam("id")Long id){

        return new ResponseEntity<>(service.getStudentById(id), HttpStatus.FOUND);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Student> updateStudent(@RequestParam("id")Long id, @RequestBody Student student){

        return new ResponseEntity<>(service.updateStudent(id, student), HttpStatus.CREATED);

    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam("id")Long id){

        service.deleteStudentById(id);
    }
}

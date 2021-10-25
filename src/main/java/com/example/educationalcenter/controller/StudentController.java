package com.example.educationalcenter.controller;

import com.example.educationalcenter.entity.Student;
import com.example.educationalcenter.service.ServiceImpl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity(studentService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity(studentService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Student student) throws Exception{
        return new ResponseEntity(studentService.add(student), HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody Student student, @PathVariable Long id) throws Exception {

        Optional<Student> AdminOptional = studentService.getById(id);

        if (!AdminOptional.isPresent())
            return ResponseEntity.notFound().build();

        student.setId(id);
        studentService.update(student);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/")
    public ResponseEntity<?> delete() throws Exception{
        studentService.delete();
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        studentService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
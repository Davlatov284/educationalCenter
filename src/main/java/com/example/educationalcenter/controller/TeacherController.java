package com.example.educationalcenter.controller;

import com.example.educationalcenter.entity.Teacher;
import com.example.educationalcenter.service.ServiceImpl.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity(teacherService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity(teacherService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Teacher student) throws Exception{
        return new ResponseEntity(teacherService.add(student), HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody Teacher student, @PathVariable Long id) throws Exception {

        Optional<Teacher> AdminOptional = teacherService.getById(id);

        if (!AdminOptional.isPresent())
            return ResponseEntity.notFound().build();

        student.setId(id);
        teacherService.update(student);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/")
    public ResponseEntity<?> delete() throws Exception{
        teacherService.delete();
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        teacherService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}



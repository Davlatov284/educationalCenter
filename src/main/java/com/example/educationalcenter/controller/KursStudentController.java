package com.example.educationalcenter.controller;

import com.example.educationalcenter.entity.KursStudent;
import com.example.educationalcenter.service.ServiceImpl.KursStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/malumot")
@CrossOrigin
public class KursStudentController {
    @Autowired
    KursStudentService kursStudentService;
    @GetMapping("/")
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity(kursStudentService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity(kursStudentService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody KursStudent kursStudent) throws Exception{
        return new ResponseEntity(kursStudentService.add(kursStudent), HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody KursStudent kursStudent, @PathVariable long id) throws Exception {


        kursStudent.setId(id);
        kursStudentService.update(kursStudent);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/")
    public ResponseEntity<?> delete() throws Exception{
        kursStudentService.delete();
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) throws Exception{
        kursStudentService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

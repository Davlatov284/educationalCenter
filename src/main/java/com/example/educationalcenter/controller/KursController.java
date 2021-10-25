package com.example.educationalcenter.controller;

import com.example.educationalcenter.entity.Kurs;
import com.example.educationalcenter.service.ServiceImpl.KursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/kurs")
public class KursController {
    @Autowired
    KursService kursService;
    @Autowired
    KursService get;

    @GetMapping("/")
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity(kursService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity(kursService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Kurs kurs) throws Exception{
        return new ResponseEntity(kursService.add(kurs), HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody Kurs kurs, @PathVariable Long id) throws Exception {


        kurs.setId(id);
        kursService.update(kurs);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/")
    public ResponseEntity<?> delete() throws Exception{
        kursService.delete();
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        kursService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
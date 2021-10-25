package com.example.educationalcenter.controller;

import com.example.educationalcenter.entity.KursTulov;
import com.example.educationalcenter.service.ServiceImpl.KursTulovService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/kursTulov")
public class KursTulovController {
    @Autowired
    KursTulovService kursTulovService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity(kursTulovService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity(kursTulovService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody KursTulov student) throws Exception{
        return new ResponseEntity(kursTulovService.add(student), HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody KursTulov student, @PathVariable Long id) throws Exception {

        Optional<KursTulov> AdminOptional = kursTulovService.getById(id);

        if (!AdminOptional.isPresent())
            return ResponseEntity.notFound().build();

        student.setId(id);
        kursTulovService.update(student);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/")
    public ResponseEntity<?> delete() throws Exception{
        kursTulovService.delete();
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        kursTulovService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

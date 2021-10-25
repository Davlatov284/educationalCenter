package com.example.educationalcenter.controller;

import com.example.educationalcenter.entity.TulovTur;
import com.example.educationalcenter.service.ServiceImpl.TulovTurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/tulovTur")
public class TulovTurController {
    @Autowired
    TulovTurService tulovTurService;

    @GetMapping("/")
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity(tulovTurService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity(tulovTurService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody TulovTur student) throws Exception{
        return new ResponseEntity(tulovTurService.add(student), HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody TulovTur student, @PathVariable Long id) throws Exception {

        Optional<TulovTur> AdminOptional = tulovTurService.getById(id);

        if (!AdminOptional.isPresent())
            return ResponseEntity.notFound().build();

        student.setId(id);
        tulovTurService.update(student);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/")
    public ResponseEntity<?> delete() throws Exception{
        tulovTurService.delete();
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
        tulovTurService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

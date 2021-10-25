package com.example.educationalcenter.service.ServiceImpl;

import com.example.educationalcenter.entity.Student;
import com.example.educationalcenter.repository.StudentRepo;
import com.example.educationalcenter.service.StudentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentSer {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAll() throws Exception {
        return studentRepo.findAll();
    }

    @Override
    public Student add(Student student) throws Exception {
        if (student.getId() == null) {
            return studentRepo.save(student);
        }else {
            throw new RuntimeException("id kerakmas");
        }
    }

    @Override
    public void update(Student student) throws Exception {
        if (student.getId() != null) {
            studentRepo.save(student);
        }else{
            throw new RuntimeException("id kerak");
        }
    }

    @Override
    public void delete() {
       studentRepo.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Optional<Student> getById(Long id) {
        return studentRepo.findById(id);
    }


}

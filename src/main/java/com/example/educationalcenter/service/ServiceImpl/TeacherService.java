package com.example.educationalcenter.service.ServiceImpl;

import com.example.educationalcenter.entity.Teacher;
import com.example.educationalcenter.repository.TeacherRepo;
import com.example.educationalcenter.service.TeacherSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements TeacherSer{
    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public List<Teacher> getAll() throws Exception {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher add(Teacher teacher) throws Exception {
        if (teacher.getId() == null) {
            return teacherRepo.save(teacher);
        }else {
            throw new RuntimeException("id kerakmas");
        }
    }

    @Override
    public void update(Teacher teacher) throws Exception {
        if (teacher.getId() != null) {
            teacherRepo.save(teacher);
        }else {
            throw new RuntimeException("id kerak");
        }
    }

    @Override
    public void delete() {
        teacherRepo.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public Optional<Teacher> getById(Long id) {
        return teacherRepo.findById(id);
    }
}

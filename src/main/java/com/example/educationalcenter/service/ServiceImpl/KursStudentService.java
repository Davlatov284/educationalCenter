package com.example.educationalcenter.service.ServiceImpl;
import com.example.educationalcenter.entity.KursStudent;
import com.example.educationalcenter.repository.KursStudentRepo;
import com.example.educationalcenter.service.KursStudentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KursStudentService implements KursStudentSer {

    @Autowired
    private KursStudentRepo kursStudentRepo;


    @Override
    public List<KursStudent> getAll() throws Exception {
        return kursStudentRepo.findAll();
    }

    @Override
    public KursStudent add(com.example.educationalcenter.entity.KursStudent kurs) throws Exception {
        if (kurs.getId() == null)
            return kursStudentRepo.save(kurs);
        throw new RuntimeException("Yangi Foydalanuvchida ID bulmaydi");
    }

    @Override
    public void update(com.example.educationalcenter.entity.KursStudent kurs) throws Exception {
        if (kurs.getId() != null){
            kursStudentRepo.save(kurs);
        }else{
            throw new RuntimeException("uzgaruvchida ID bulishi shart");
        }
    }

    @Override
    public void delete() {
        kursStudentRepo.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        kursStudentRepo.deleteById(id);
    }

    @Override
    public Optional<KursStudent> getById(Long id) {
        return kursStudentRepo.findById(id);
    }

}

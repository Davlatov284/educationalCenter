package com.example.educationalcenter.service.ServiceImpl;

import com.example.educationalcenter.entity.Kurs;
import com.example.educationalcenter.repository.KursRepo;
import com.example.educationalcenter.service.KursSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KursService implements KursSer {
    @Autowired
    private KursRepo kursRepo;

    @Override
    public List<Kurs> getAll() throws Exception {
        return kursRepo.findAll();
    }

    @Override
    public Kurs add(Kurs kurs) throws Exception {
        if(kurs.getId() == null)
        return kursRepo.save(kurs);
        throw new RuntimeException("Yangi Foydalanuvchida ID bulmaydi");
    }

    @Override
    public void update(Kurs kurs) throws Exception {
        if (kurs.getId() != null) {
            kursRepo.save(kurs);
        }else {
            throw new RuntimeException("uzgaruvchida ID bulishi shart");
        }
    }

    @Override
    public void delete() {
        kursRepo.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        kursRepo.deleteById(id);
    }

    @Override
    public Optional<Kurs> getById(Long id) {
        return kursRepo.findById(id);
    }


}

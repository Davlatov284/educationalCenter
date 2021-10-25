package com.example.educationalcenter.service.ServiceImpl;

import com.example.educationalcenter.entity.KursTulov;
import com.example.educationalcenter.repository.KursTulovRepo;
import com.example.educationalcenter.service.KursTulovSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KursTulovService implements KursTulovSer {
    @Autowired
    private KursTulovRepo kursTulovRepo;

    @Override
    public List<KursTulov> getAll() throws Exception {
        return kursTulovRepo.findAll();
    }

    @Override
    public KursTulov add(KursTulov kursTulov) throws Exception {
        if (kursTulov.getId() == null){
            return kursTulovRepo.save(kursTulov);
        }else{
            throw new RuntimeException("ID bulmaydi");
        }
    }

    @Override
    public void update(KursTulov kursTulov) throws Exception {
        if (kursTulov.getId() != null){
            kursTulovRepo.save(kursTulov);
        }else{
            throw new RuntimeException("ID bulishi kerak");
        }
    }

    @Override
    public void delete() {
        kursTulovRepo.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        kursTulovRepo.deleteById(id);
    }

    @Override
    public Optional<KursTulov> getById(Long id) {
        return kursTulovRepo.findById(id);
    }
}

package com.example.educationalcenter.service.ServiceImpl;

import com.example.educationalcenter.entity.TulovTur;
import com.example.educationalcenter.repository.TulovTurRepo;
import com.example.educationalcenter.service.TulovTurSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TulovTurService implements TulovTurSer {
    @Autowired
    TulovTurRepo tulovTurRepo;

    @Override
    public List<TulovTur> getAll() throws Exception {
        return tulovTurRepo.findAll();
    }

    @Override
    public TulovTur add(TulovTur tulovTur) throws Exception {
        if (tulovTur.getId() == null) {
            return tulovTurRepo.save(tulovTur);
        }else {
            throw new RuntimeException("id kerakmas");
        }
    }

    @Override
    public void update(TulovTur tulovTur) throws Exception {
        if (tulovTur.getId() != null) {
            tulovTurRepo.save(tulovTur);
        }else {
            throw new RuntimeException("id kerakmas");
        }
    }

    @Override
    public void delete() {
        tulovTurRepo.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        tulovTurRepo.deleteById(id);
    }

    @Override
    public Optional<TulovTur> getById(Long id) {
        return tulovTurRepo.findById(id);
    }
}

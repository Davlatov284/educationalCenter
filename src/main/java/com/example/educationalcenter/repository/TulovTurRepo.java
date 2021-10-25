package com.example.educationalcenter.repository;

import com.example.educationalcenter.entity.TulovTur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TulovTurRepo extends JpaRepository<TulovTur, Long> {
}

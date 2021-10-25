package com.example.educationalcenter.repository;

import com.example.educationalcenter.entity.KursTulov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KursTulovRepo extends JpaRepository<KursTulov, Long> {
}

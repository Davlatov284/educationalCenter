package com.example.educationalcenter.repository;

import com.example.educationalcenter.entity.Kurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KursRepo extends JpaRepository<Kurs, Long> {
}

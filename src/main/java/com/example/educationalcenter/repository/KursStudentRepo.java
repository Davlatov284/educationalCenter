package com.example.educationalcenter.repository;

import com.example.educationalcenter.entity.Kurs;
import com.example.educationalcenter.entity.KursStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KursStudentRepo extends JpaRepository<KursStudent, Long> {
}

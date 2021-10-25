package com.example.educationalcenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "kurs_student")
public class KursStudent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String kelganVaqt;
    private boolean status;
    private String ketganVaqt;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Kurs kurs;

    public KursStudent(String kelganVaqt, boolean status, String ketganVaqt, Student student, Kurs kurs) {
        this.kelganVaqt = kelganVaqt;
        this.status = status;
        this.ketganVaqt = ketganVaqt;
        this.student = student;
        this.kurs = kurs;
    }

    public KursStudent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKelganVaqt() {
        return kelganVaqt;
    }

    public void setKelganVaqt(String kelganVaqt) {
        this.kelganVaqt = kelganVaqt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getKetganVaqt() {
        return ketganVaqt;
    }

    public void setKetganVaqt(String ketganVaqt) {
        this.ketganVaqt = ketganVaqt;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }
}


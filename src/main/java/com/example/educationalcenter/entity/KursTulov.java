package com.example.educationalcenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "kurs_tulov")
public class KursTulov implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String date;
    @ManyToOne
    private KursStudent kursStudent;
    @ManyToOne
    private TulovTur tulovTur;


    public KursTulov(String date, KursStudent kursStudent, TulovTur tulovTur) {
        this.date = date;
        this.kursStudent = kursStudent;
        this.tulovTur = tulovTur;
    }

    public KursTulov() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public KursStudent getKursStudent() {
        return kursStudent;
    }

    public void setKursStudent(KursStudent kursStudent) {
        this.kursStudent = kursStudent;
    }

    public TulovTur getTulovTur() {
        return tulovTur;
    }

    public void setTulovTur(TulovTur tulovTur) {
        this.tulovTur = tulovTur;
    }
}

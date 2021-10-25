package com.example.educationalcenter.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tulov_tur")
public class TulovTur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String tulovTur;

    public TulovTur(String tulovTur) {
        this.tulovTur = tulovTur;
    }

    public TulovTur() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTulovTur() {
        return tulovTur;
    }

    public void setTulovTur(String tulovTur) {
        this.tulovTur = tulovTur;
    }
}

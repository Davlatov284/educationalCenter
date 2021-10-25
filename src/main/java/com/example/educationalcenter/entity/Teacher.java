package com.example.educationalcenter.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;

    public Teacher(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Teacher() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

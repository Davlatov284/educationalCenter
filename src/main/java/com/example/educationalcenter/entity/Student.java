package com.example.educationalcenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    private String fatherName;
    private String birthday;
    private String telNomer;

    public Student() {
    }

    public Student(String name, String surname, String fatherName, String birthday, String telNomer) {
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.birthday = birthday;
        this.telNomer = telNomer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelNomer() {
        return telNomer;
    }

    public void setTelNomer(String telNomer) {
        this.telNomer = telNomer;
    }
}

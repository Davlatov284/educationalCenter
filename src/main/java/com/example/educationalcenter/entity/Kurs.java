package com.example.educationalcenter.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "kurs")
public class Kurs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String cost;
    private String level;
    private String room;
    private String yunalishi;
    private String startTime;
    private String endTime;
    private String kunlari;
    @ManyToOne
    private Teacher teacher;

    public Kurs() {
    }

    public Kurs(String name, String cost, String level, String room, String yunalishi, String startTime, String endTime, String kunlari, Teacher teacher) {
        this.name = name;
        this.cost = cost;
        this.level = level;
        this.room = room;
        this.yunalishi = yunalishi;
        this.startTime = startTime;
        this.endTime = endTime;
        this.kunlari = kunlari;
        this.teacher = teacher;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getYunalishi() {
        return yunalishi;
    }

    public void setYunalishi(String yunalishi) {
        this.yunalishi = yunalishi;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getKunlari() {
        return kunlari;
    }

    public void setKunlari(String kunlari) {
        this.kunlari = kunlari;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

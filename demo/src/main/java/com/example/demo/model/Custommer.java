package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "custommer")

public class Custommer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CustommerID;
    @Column(nullable = false)
    private String Name;

    @Column(nullable = false)
    private String Surname;

    @Column(nullable = false)
    private String Adress;

    @Column(nullable = false)
    private String Number;

    public Integer getCustommerID() {
        return CustommerID;
    }

    public void setCustommerID(Integer custommerID) {
        CustommerID = custommerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}

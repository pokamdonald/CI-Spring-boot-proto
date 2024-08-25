package com.plus_api.central_plus.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

    private String name;
    private String surname;
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private  LocalDate updateDate;
    private String  role;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




}

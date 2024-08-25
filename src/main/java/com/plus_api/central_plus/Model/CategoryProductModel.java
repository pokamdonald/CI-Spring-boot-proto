package com.plus_api.central_plus.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CategoryProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String categoryname;

    private  String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Creation_date", columnDefinition = "DATE")
    private LocalDate creation_date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "update_date", columnDefinition = "DATE")
    private  LocalDate update_date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }

    public LocalDate getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDate update_date) {
        this.update_date = update_date;
    }



}

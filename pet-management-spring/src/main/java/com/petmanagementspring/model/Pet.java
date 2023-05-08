package com.petmanagementspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private long code;

    @Column(name = "type")
    private String type;

    @Column(name = "color")
    private String color;

    @Column(name = "country")
    private String country;

    public Pet() {}

    public Pet(String name, long code, String type, String color, String country) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.color = color;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getCode() {
        return code;
    }
    public void setCode(long code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Pet [name=" + name + 
                ", code=" + code + 
                ", type=" + type + 
                ", color=" + color + 
                ", country=" + country + "]";
    }
}

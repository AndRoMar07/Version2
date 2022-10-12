package com.doctors.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="admin")

public class AdminModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Integer password;

    public AdminModel() {
    }

    public AdminModel(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public AdminModel(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return password;
    }

    public void setAge(Integer age) {
        this.password = age;
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                '}';
    }

}

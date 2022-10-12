package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.bridge.IMessage;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "doctor")
public class DoctorModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    private String department;

    private Integer years;

    private String description;

    @ManyToOne
    @JoinColumn(name="specialtyId")
    @JsonIgnoreProperties("doctors")
    private SpecialtyModel specialty;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor","client"})
    private List<MessageModel> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "messages"})
    private List<ReservationModel> reservations;



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


    @Override
    public String toString() {
        return "DoctorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", years=" + years +
                ", description='" + description + '\'' +
                ", specialty=" + specialty +
                ", messages=" + messages +
                ", reservations=" + reservations +
                '}';
    }
}

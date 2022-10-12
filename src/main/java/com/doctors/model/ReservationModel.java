package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="reservation")
public class ReservationModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResevation;

    private Date starDate;

    private Date devolutionDate;

    private String status="created";

    @ManyToOne
    @JoinColumn(name="doctorId")
    @JsonIgnoreProperties("reservations")
    private DoctorModel doctor;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor","client"})
    private List<MessageModel> messages;

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private ScoreModel score;

    @ManyToOne
    @JoinColumn(name="client")
    @JsonIgnoreProperties("reservations")
    private ClientModel client;

    public Integer getIdResevation() {
        return idResevation;
    }

    public void setIdResevation(Integer idResevation) {
        this.idResevation = idResevation;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }

    public List<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageModel> messages) {
        this.messages = messages;
    }

    public ScoreModel getScore() {
        return score;
    }

    public void setScore(ScoreModel score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ReservationModel{" +
                "idResevation=" + idResevation +
                ", starDate=" + starDate +
                ", devolutionDate=" + devolutionDate +
                ", status='" + status + '\'' +
                ", doctor=" + doctor +
                ", messages=" + messages +
                ", score=" + score +
                '}';
    }

}

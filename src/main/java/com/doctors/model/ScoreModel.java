package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="score")

public class ScoreModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer score;

    @OneToOne
    @JsonIgnoreProperties("score")
    private ReservationModel reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public ReservationModel getReservations() {
        return reservation;
    }

    public void setReservations(ReservationModel reservations) {
        this.reservation = reservations;
    }

    @Override
    public String toString() {
        return "ScoreModel{" +
                "id=" + id +
                ", score=" + score +
                ", reservations=" + reservation +
                '}';
    }
}

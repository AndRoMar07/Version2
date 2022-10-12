package com.doctors.service;

import com.doctors.model.ReservationModel;
import com.doctors.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservations(){
        return reservationRepository.getAllReservations();
    }

    public Optional<ReservationModel> getReservation(Integer id){
        return reservationRepository.getReservation(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel) {
        if (reservationModel.getIdResevation() == null) {
            return reservationRepository.saveReservation(reservationModel);
        } else {
            Optional<ReservationModel> reservationModel1 = reservationRepository.getReservation(reservationModel.getIdResevation());
            if (reservationModel1.isEmpty()) {
                return reservationRepository.saveReservation(reservationModel);
            } else {
                return reservationModel;
            }
        }
    }
    public boolean deleteReservation(Integer id){ return reservationRepository.deleteReservation(id);
    }

    public ReservationModel updateReservation(ReservationModel reservationModel){ return reservationRepository.updateReservation(reservationModel);
    }
}

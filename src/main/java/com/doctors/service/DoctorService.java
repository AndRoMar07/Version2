package com.doctors.service;

import com.doctors.model.DoctorModel;
import com.doctors.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorModel> getAllDoctors(){
        return doctorRepository.getAllDoctors();
    }

    public Optional<DoctorModel> getDoctor(Integer id){
        return doctorRepository.getDoctor(id);
    }

    public DoctorModel saveDoctor(DoctorModel doctorModel) {
        if (doctorModel.getId() == null) {
            return doctorRepository.saveDoctor(doctorModel);
        } else {
            Optional<DoctorModel> doctorModel1 = doctorRepository.getDoctor(doctorModel.getId());
            if (doctorModel1.isEmpty()) {
                return doctorRepository.saveDoctor(doctorModel);
            } else {
                return doctorModel;
            }
        }
    }
    public boolean deleteDoctor(Integer id){
        return doctorRepository.deleteDoctor(id);
    }

    public DoctorModel updateDoctor(DoctorModel doctorModel){
        return doctorRepository.updateDoctor(doctorModel);
    }
}

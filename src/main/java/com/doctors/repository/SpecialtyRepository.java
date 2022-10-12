package com.doctors.repository;

import com.doctors.model.SpecialtyModel;
import com.doctors.repository.crudrepository.SpecialtyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecialtyRepository {
    @Autowired
    private SpecialtyCrudRepository specialtyCrudRepository;

    public List<SpecialtyModel> getAllDepartments(){
        return (List<SpecialtyModel>) specialtyCrudRepository.findAll();
    }

    public Optional<SpecialtyModel> getDepartment(Integer id){
        return specialtyCrudRepository.findById(id);
    }

    public SpecialtyModel saveDepartment(SpecialtyModel specialtyModel){
        return specialtyCrudRepository.save(specialtyModel);
    }

    public boolean deleteDepartment(Integer id){
        specialtyCrudRepository.deleteById(id);
        return true;
    }

    public SpecialtyModel updateDepartment(SpecialtyModel specialtyModel){
        return specialtyCrudRepository.save(specialtyModel);
    }
}

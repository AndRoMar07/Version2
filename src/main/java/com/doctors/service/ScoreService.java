package com.doctors.service;

import com.doctors.model.DoctorModel;
import com.doctors.model.ScoreModel;
import com.doctors.repository.DoctorRepository;
import com.doctors.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {


    @Autowired
    private ScoreRepository scoreRepository;

    public List<ScoreModel> getAllScores(){
        return scoreRepository.getAllScores();
    }
    public Optional<ScoreModel> getScore (Integer id){
        return scoreRepository.getScore(id);
    }
    public ScoreModel saveScore(ScoreModel scoreModel) {
        if (scoreModel.getId()==null) {
            return scoreRepository.saveScore(scoreModel);
        } else {
            Optional<ScoreModel> scoreModel1 = scoreRepository.getScore(scoreModel.getId());
            if (scoreModel1.isEmpty()) {
                return scoreRepository.saveScore(scoreModel);
            } else {
                return scoreModel;
            }
        }
    }
    public boolean deleteScore(Integer id){
        return scoreRepository.deleteScore(id);
    }
    public ScoreModel updateScore (ScoreModel scoreModel){
        return scoreRepository.updateScore(scoreModel);
    }

}
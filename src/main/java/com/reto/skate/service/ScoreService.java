package com.reto.skate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.skate.model.Score;
import com.reto.skate.repository.ScoreRepository;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> obtenerScoreCompleta(){
        return scoreRepository.obtenerScoreCompleta();

    }

    public Optional<Score> obtenerScoreId(Integer id){
        return scoreRepository.obtenerScoreId(id);
    }

    public Score salvarScore(Score score){
        if(score.getIdScore()==null){
            return scoreRepository.salvarScore(score);
            }
            else{
                Optional<Score> scoreAuxiliar=scoreRepository.obtenerScoreId(score.getIdScore());
                if(scoreAuxiliar.isEmpty()){
                    return scoreRepository.salvarScore(score);
                }
                else{
                    return score;
                }
                    
            }  
        }
        public Score updateScore(Score score){
            if(score.getIdScore()!=null){
                Optional<Score> scoreAuxiliar = scoreRepository.obtenerScoreId(score.getIdScore());
                if(!scoreAuxiliar.isEmpty()){
                    if(score.getMessageText()!=null){
                        scoreAuxiliar.get().setMessageText(score.getMessageText());
                    }
                    if(score.getStars()!=null){
                        scoreAuxiliar.get().setStars(score.getStars());
                    }
                    scoreRepository.salvarScore(scoreAuxiliar.get());
                    return scoreAuxiliar.get();
                }else{
                    return score;
                }
            }else{
                return score;
            }
        }
    
        public boolean deleteScore(Integer scoreId){
            boolean flag=false;
            Optional<Score> scoreAuxiliar = scoreRepository.obtenerScoreId(scoreId);
            if(scoreAuxiliar.isPresent()){
                scoreRepository.delete(scoreAuxiliar.get());
                flag=true;
            }
            return flag;
        } 
}

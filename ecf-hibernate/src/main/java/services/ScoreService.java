package services;

import daoImpl.ScoreDAO;
import entities.Score;

import java.util.List;

public class ScoreService {
    private ScoreDAO scoreDAO;

    public ScoreService(ScoreDAO scoreDAO) {
        this.scoreDAO = scoreDAO;
    }
    public  boolean addNewScore (Score score){
        return  scoreDAO.create(score);
    }
    public  Score getScoreById (int id){
        return  scoreDAO.findById(id);
    }
    public List<Score> getAllScoreByStudent(int id){
        return scoreDAO.getAllScoresByStudent(id);
    }
    public Double getGPAByStudent(int id){
        return scoreDAO.getGPAByStudent(id);
    }
    public void close(){
        scoreDAO.close();
    }
}

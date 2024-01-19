package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subj", nullable = false)
    private int idSubj;

    private String subjName;
    private String description;
    private int coefficient;
    private int during;
    @OneToMany(mappedBy = "subject")
    private List<Score> scores = new ArrayList<>();

    public Subject() {
    }

    public Subject(String subjName, String description, int coefficient, int during, List<Score> scores) {
        this.subjName = subjName;
        this.description = description;
        this.coefficient = coefficient;
        this.during = during;
        this.scores = scores;
    }

    public Subject(String subjName, String description, int coefficient, int during) {
        this.subjName = subjName;
        this.description = description;
        this.coefficient = coefficient;
        this.during = during;
    }

    public int getIdSubj() {
        return idSubj;
    }

    public void setIdSubj(int idSubj) {
        this.idSubj = idSubj;
    }

    public String getSubjName() {
        return subjName;
    }

    public void setSubjName(String subjName) {
        this.subjName = subjName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getDuring() {
        return during;
    }

    public void setDuring(int during) {
        this.during = during;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
    public void addScore(Score score) {
        if (scores == null) {
            scores = new ArrayList<>();
        }
        scores.add(score);
        score.setSubject(this);
    }
    public void removeScore(Score score) {
        if (scores != null) {
            scores.remove(score);
            score.setSubject(null);
        }
    }

}

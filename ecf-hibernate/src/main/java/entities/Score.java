package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score", nullable = false)
    private int idScore;

    private String comment;
    private double score;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "id_subj")
    private Subject subject;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private Student student;

    public Score() {
    }

    public Score(String comment, double score, Subject subject, Student student) {
        this.comment = comment;
        this.score = score;
        this.subject = subject;
        this.student = student;
    }

    public int getIdScore() {
        return idScore;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }



}

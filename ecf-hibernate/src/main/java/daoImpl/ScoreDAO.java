package daoImpl;

import dao.Repository;
import entities.Professor;
import entities.Schedule;
import entities.Score;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ScoreDAO extends BaseDAO implements Repository <Score>{
     public Session session;
     public Transaction transaction;

    public ScoreDAO() {super();
    }

    @Override
    public boolean create(Score o) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Score findById(int id) {
        try {
            session = sessionFactory.openSession();
            Score score = session.get(Score.class, id);
            return score;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Score> findAll() {
        try{
            session=sessionFactory.openSession();
            List<Score> score = new ArrayList<>();
            Query<Score> q = session.createQuery(" from Score sc ");
            score =q.list();
            return score;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Score> getAllScoresByStudent(int id){
        try {
            session = sessionFactory.openSession();
            List<Score> scores = new ArrayList<>();
            Query<Score> query = session.createQuery("SELECT s.firstName, s.lastName, su.subjName, sc.comment, sc.score " +
                    "FROM Student s JOIN s.scores sc JOIN sc.subject su " +
                    "WHERE s.idStudent = :id");

            query.setParameter("id", id);
           scores = query.list();
            return scores;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    //Grade Point Average = GPA : moyenne pondérée cumulative

    public Double getGPAByStudent(int studentId) {
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query<Double> query = session.createQuery(
                    "SELECT AVG(sc.score) FROM Student s " +
                            "JOIN Score sc ON s.idStudent = sc.student.idStudent " +
                            "WHERE s.idStudent = :studentId", Double.class);


            query.setParameter("studentId", studentId);
            Double jpa = query.uniqueResult();

            transaction.commit();
            return jpa;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

}

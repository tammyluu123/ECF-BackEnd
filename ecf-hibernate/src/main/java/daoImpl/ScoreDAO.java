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
}

package daoImpl;

import dao.Repository;
import entities.Schedule;
import entities.Subject;
import entities.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubjectDAO extends  BaseDAO implements Repository<Subject> {
    public Session session;
    public Transaction transaction;

    public SubjectDAO() {super();
    }

    @Override
    public boolean create(Subject o) {

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
    public Subject findById(int id) {
        try {
            session = sessionFactory.openSession();
            Subject subj = session.get(Subject.class, id);
            return subj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Subject> findAll() {
        try {
            session = sessionFactory.openSession();
            List<Subject> subj = new ArrayList<>();
            Query<Subject> q = session.createQuery(" from Subject s ");
            subj = q.list();
            return subj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Subject> countSubjetsByStudent(int id){
        try {
            session = sessionFactory.openSession();
            List<Subject> subjects = new ArrayList<>();
            Query<Subject> q = session.createQuery("SELECT s.id, s.firstName, s.lastName, Count(sc.id)  " +
                    "FROM Student  s LEFT JOIN s.scores sc " +
                    "WHERE s.idStudent = :id GROUP BY s.firstName, s.lastName");
            q.setParameter("id",id);
            List<Subject> amountSubjects = q.list();
            return  amountSubjects;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;

    }
}

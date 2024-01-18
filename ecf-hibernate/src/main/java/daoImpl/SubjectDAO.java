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

public class SubjectDAO extends  BaseDAO implements Repository<Subject> {
    public Session session;
    public Transaction transaction;
    @Override
    public boolean create(Subject o) {
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
}

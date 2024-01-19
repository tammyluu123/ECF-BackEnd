package daoImpl;

import dao.Repository;
import entities.Professor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO extends BaseDAO implements Repository<Professor> {
    public Session session;
    public Transaction transaction;
    public ProfessorDAO() { super();
    }

    @Override
    public boolean create(Professor o) {

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
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Professor professor = session.get(Professor.class, id);
            session.delete(professor);
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
    public Professor findById(int id) {

        return null;
    }

    public  Professor findByRegisterNumber (int registerNum){
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Professor professor = session.get(Professor.class, registerNum);
            return professor;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
    @Override
    public List<Professor> findAll() {
        try{
            session=sessionFactory.openSession();
            List<Professor> professors = new ArrayList<>();
            Query<Professor> q = session.createQuery(" from Professor p ");
            professors =q.list();
            return professors;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean update(Professor professor) {
        transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(professor);
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
}

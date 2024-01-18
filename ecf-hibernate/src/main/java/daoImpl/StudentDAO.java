package daoImpl;

import dao.Repository;
import entities.Student;
import entities.Student;
import entities.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends BaseDAO implements Repository<Student> {
    public Session session;
    public Transaction transaction;
    @Override
    public boolean create(Student o) {
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
    public Student findById(int id) {
        try {
            session = sessionFactory.openSession();
            Student student = session.get(Student.class, id);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        try{
            session=sessionFactory.openSession();
            List<Student> student = new ArrayList<>();
            Query<Student> q = session.createQuery(" from Student sc ");
            student =q.list();
            return student;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package daoImpl;

import dao.Repository;
import entities.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends BaseDAO implements Repository<Student> {
    public Session session;
    public Transaction transaction;

    public StudentDAO() {super();
    }

    @Override
    public boolean create(Student o) {
        session= null;
        transaction = null;
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
            Student student = session.get(Student.class,id);
            if (student != null) {
                session.delete(student);
            }
            session.getTransaction().commit();
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
    public boolean update(Student student) {

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
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

    public long countStudentsByDepartment(int idDept){
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query<Long> query = session.createQuery(
                    "SELECT COUNT(s.idStudent) FROM Departement d " +
                            "JOIN ClassRoom c ON d.idDept = c.departement.idDept " +
                            "JOIN Student s ON c.idClass = s.classRooms.idClass " +
                            "WHERE d.idDept = :deptId", Long.class);

            query.setParameter("deptId", idDept);
            long count = query.uniqueResult();
            transaction.commit();
            return count;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 0;
    }
    public List<Object[]> getStudentsByClassLevel(String level) {
        try {
            session = sessionFactory.openSession();
            Query<Object[]> q = session.createQuery("SELECT c.level, s.firstName, s.lastName " +
                    "FROM ClassRoom c JOIN c.studentList s " +
                    "WHERE c.level = :level");
            q.setParameter("level", level);
            List<Object[]> result = q.list();
            return result;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


}

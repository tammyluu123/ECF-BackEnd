package daoImpl;

import entities.ClassRoom;
import dao.Repository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ClassDAO extends BaseDAO implements Repository <ClassRoom> {
    public Session session;
    public Transaction transaction;

    public ClassDAO() {super();
    }


    @Override
    public boolean create(ClassRoom o) {

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
            ClassRoom classroom = session.get(ClassRoom.class,id);
            if (classroom != null) {
                session.delete(classroom);
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
    public ClassRoom findById(int id) {
        Session session = null;
        try{
            session=sessionFactory.openSession();
           ClassRoom ClassRoom = session.get(ClassRoom.class,id);
            return ClassRoom;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<ClassRoom> findAll() {
         try{
            session=sessionFactory.openSession();
            List<ClassRoom> classroomList = new ArrayList<>();
            Query<ClassRoom> classroomQuery = session.createQuery(" from ClassRoom c ");
            classroomList =classroomQuery.list();
            return classroomList;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

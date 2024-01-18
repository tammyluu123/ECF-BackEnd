package daoImpl;

import entities.Departement;
import entities.Departement;
import dao.Repository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DepartementDAO extends BaseDAO implements Repository<Departement> {
    public Session session;
    public  Transaction transaction;

    public DepartementDAO() {super();
    }

    @Override
    public boolean create(Departement o) {

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
            Departement department = session.get(Departement.class, id);
            session.delete(department);
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
    public Departement findById(int id) {
        try {
            session = sessionFactory.openSession();
            Departement department = session.get(Departement.class, id);
            return department;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Departement> findAll() {

        try{
            session=sessionFactory.openSession();
            List<Departement> departementList = new ArrayList<>();
            Query<Departement> classroomQuery = session.createQuery(" from Departement d ");
            departementList =classroomQuery.list();
            return departementList;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

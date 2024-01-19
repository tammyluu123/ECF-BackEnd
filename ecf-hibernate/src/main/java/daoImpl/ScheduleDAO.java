package daoImpl;

import dao.Repository;
import entities.Schedule;
import entities.Schedule;
import entities.Schedule;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO  extends BaseDAO implements Repository<Schedule> {
    public Session session;
    public Transaction transaction;

    public ScheduleDAO() {super();
    }

    @Override
    public boolean create(Schedule o) {
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
    public Schedule findById(int id) {
        try {
            session = sessionFactory.openSession();
            Schedule schedule = session.get(Schedule.class, id);
            return schedule;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Schedule> findAll() {
        try{
            session=sessionFactory.openSession();
            List<Schedule> schedules = new ArrayList<>();
            Query<Schedule> query = session.createQuery(" from Schedule d ");
            schedules =query.list();
            return schedules;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

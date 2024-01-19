package services;

import daoImpl.ScheduleDAO;
import entities.Schedule;

public class ScheduleService {
    private ScheduleDAO scheduleDAO;

    public ScheduleService(ScheduleDAO scheduleDAO) {
        this.scheduleDAO = scheduleDAO;
    }
    public boolean addNewSchedule (Schedule schedule){
        return scheduleDAO.create(schedule);
    }
    public void close(){
        scheduleDAO.close();
    }
}

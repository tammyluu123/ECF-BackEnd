package services;

import daoImpl.SubjectDAO;
import entities.Subject;

import java.util.List;

public class SubjectService {
    private SubjectDAO subjectDAO;

    public SubjectService(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }
    public  boolean addNewSubject (Subject subj){
        return subjectDAO.create(subj);
    }
    public  Subject getSubjectById (int id){
        return  subjectDAO.findById(id);
    }
    public List<Subject> countSubjectsByStudent (int id){
        return  subjectDAO.countSubjetsByStudent(id);
    }
    public void close(){
       subjectDAO.close();
    }
}

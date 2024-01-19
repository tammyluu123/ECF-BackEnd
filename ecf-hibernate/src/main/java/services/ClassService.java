package services;

import daoImpl.ClassDAO;
import entities.ClassRoom;

import java.util.List;

public class ClassService {
    private ClassDAO classDAO;

    public ClassService(ClassDAO classDAO) {
        this.classDAO = classDAO;
    }
    public  boolean addNewClass (ClassRoom classRoom){

        if (classRoom != null) {
            classDAO.create(classRoom);
            return true;
        } else {
            System.out.println("Erreur: la classe n'a pas pu être ajoutée.");
            return false;
        }
    }
    public ClassRoom getClassById(int id){
        return  classDAO.findById(id);
    }
    public List<ClassRoom> getAllClass(){
        return classDAO.findAll();
    }
    public boolean deleteClassById(int id){
        return  classDAO.delete(id);
    }
    public void close(){
        classDAO.close();
    }
}

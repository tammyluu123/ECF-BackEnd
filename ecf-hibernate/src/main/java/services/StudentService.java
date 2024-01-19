package services;

import daoImpl.StudentDAO;
import entities.Student;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    public  boolean addNewStudent (Student student){

        if (studentDAO != null) {
            return studentDAO.create(student);
        } else {
            System.out.println("Erreur : studentDAO non initialisé.");
            return false;
        }
    }
    public  Student getStudentById (int id){
        return  studentDAO.findById(id);
    }
    public boolean updateStudent(Student student) {
        if (studentDAO.update(student)) {
            return true;
        }
        return false;
    }
    public  Long countStudentsByDepartment(int id){
        return  studentDAO.countStudentsByDepartment(id);
    }
    public List<Object[]> getStudentsByClassLevel(String level) {
        return studentDAO.getStudentsByClassLevel(level);
    }
    public boolean deleteStudent(int id)  {

        return  studentDAO.delete(id);
    }
    public void close(){
        studentDAO.close();
    }
}

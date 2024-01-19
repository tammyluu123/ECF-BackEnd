package services;

import daoImpl.ProfessorDAO;
import entities.Professor;

public class ProfessorService {
    private ProfessorDAO professorDAO;
    public ProfessorService() {
    }
    public ProfessorService(ProfessorDAO professorDAO) {
        this.professorDAO = professorDAO;
    }

    public boolean addNewProfessor (Professor prof){
        return  professorDAO.create(prof);
    }
    public  Professor getProfessorByRegisterNumber (int registerNum){
        return  professorDAO.findByRegisterNumber(registerNum);
    }
    public void updateProfessor(Professor professor) {
        professorDAO.update(professor);
    }
    public void close(){
       professorDAO.close();
    }

}

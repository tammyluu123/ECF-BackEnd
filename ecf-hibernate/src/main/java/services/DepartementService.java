package services;

import daoImpl.DepartementDAO;
import entities.Departement;
import entities.Professor;

public class DepartementService {
    private DepartementDAO departementDAO ;
    private ProfessorService professorService;

    public DepartementService(DepartementDAO departementDAO){
        this.departementDAO = departementDAO;

    }



    public void addNewDepartement(Departement departement) {
        this.departementDAO.create(departement);
    }
    public  Departement getDepartementById (int idDept){
        if (departementDAO != null) {
            return departementDAO.findById(idDept);
        } else {
            // Handle the case where departementDAO is null
            System.out.println("Error: departementDAO is not initialized");
            return null;
        }
    }
    public boolean addProfessorByDepartment(Professor professor, int id) {
        Departement department = this.departementDAO.findById(id);
        if (department != null) {
            professor.setDepartement(department);
            professorService.updateProfessor(professor);
            return true;
        } else {
            System.out.println("Département non trouvé avec l'ID " + id);
            return false;
        }
    }
    public void close(){
        departementDAO.close();
    }

}


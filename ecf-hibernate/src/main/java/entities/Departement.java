package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_department", nullable = false)
    private int idDept;

    private String deptName;

    @OneToMany(mappedBy = "departement")
    private Set<Professor> professor;
    @OneToMany(mappedBy = "departement")
    private List<ClassRoom> classes = new ArrayList<>();

    public Departement() {
    }

    public Departement(String deptName) {
        this.deptName = deptName;
    }

    public Departement(String deptName, Set<Professor> professor, List<ClassRoom> classes) {
        this.deptName = deptName;
        this.professor = professor;
        this.classes = classes;
    }

    public int getIdDept() {
        return idDept;
    }

    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Professor> getProfessor() {
        return professor;
    }

    public void setProfessor(Set<Professor> professor) {
        this.professor = professor;
    }

    public List<ClassRoom> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassRoom> classes) {
        this.classes = classes;
    }
}

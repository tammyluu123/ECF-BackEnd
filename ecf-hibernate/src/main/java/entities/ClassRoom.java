package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "class")
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class", nullable = false)
    private int idClass;

    private String className;
    private String level;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Dept")
    private Departement department;
    @OneToMany (mappedBy = "class")
    private Set<Student> studentList = new HashSet<>();
    @ManyToMany(mappedBy = "class", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Professor> professors = new HashSet<>();

    public ClassRoom() {
    }

    public ClassRoom(String className, String level, Departement department, Set<Student> studentList, Set<Professor> professors) {
        this.className = className;
        this.level = level;
        this.department = department;
        this.studentList = studentList;
        this.professors = professors;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Departement getDepartment() {
        return department;
    }

    public void setDepartment(Departement department) {
        this.department = department;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }

    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }
}

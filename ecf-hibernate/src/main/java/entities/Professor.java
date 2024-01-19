package entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_Number")
    private int registerNumber;
    @NotNull
    private String firstName;
    private String lastName;
    private int age;
    private boolean profPrincipal;
    private int grade;
    @ManyToMany
    @JoinTable(
            name = "professor_classroom",
            joinColumns = @JoinColumn(name = "register_Number"),
            inverseJoinColumns = @JoinColumn(name = "id_class")
    )
    private Set<ClassRoom> classRooms;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "id_department")
    private Departement departement;
    public Professor() {
    }

    public Professor(String firstName, String lastName, int age, boolean profPrincipal, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.profPrincipal = profPrincipal;
        this.grade = grade;
    }

    public Professor(String lastName, String firstName, int age, boolean isPrincipal, int grade, Departement departement) {
    }

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isProfPrincipal() {
        return profPrincipal;
    }

    public void setProfPrincipal(boolean profPrincipal) {
        this.profPrincipal = profPrincipal;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Set<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(Set<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }
}

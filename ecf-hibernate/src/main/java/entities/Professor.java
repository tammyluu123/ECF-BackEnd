package entities;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String registerNumber;
    @NotNull
    private String firstName;
    private String lastName;
    private int age;
    private boolean profPrincipal;
    private int grade;

    public Professor() {
    }

    public Professor(String firstName, String lastName, int age, boolean profPrincipal, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.profPrincipal = profPrincipal;
        this.grade = grade;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
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
}

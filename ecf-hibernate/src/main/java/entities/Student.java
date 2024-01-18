package entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudent;
    @NotNull
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_day_class")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassRoom studentClass;
    @OneToMany(mappedBy = "student")
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<Score> scores = new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, String dateOfBirth, String email, Schedule schedule, ClassRoom studentClass, List<Schedule> schedules, List<Score> scores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.schedule = schedule;
        this.studentClass = studentClass;
        this.schedules = schedules;
        this.scores = scores;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public ClassRoom getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(ClassRoom studentClass) {
        this.studentClass = studentClass;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<Score> getScores() {
        return scores;
    }
}

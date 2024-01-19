package entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student" )
    private int idStudent;
    @NotNull
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_day_class")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassRoom classRooms;
    @OneToMany(mappedBy = "student")
    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<Score> scores = new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, Date dateOfBirth, String email, Schedule schedule, ClassRoom classRooms, List<Schedule> schedules, List<Score> scores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.schedule = schedule;
        this.classRooms = classRooms;
        this.schedules = schedules;
        this.scores = scores;
    }

    public Student(String firstName, String lastName, Date dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public ClassRoom getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(ClassRoom classRooms) {
        this.classRooms = classRooms;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public List<Score> getScores() {
        return scores;
    }

    public boolean showProfile(){
        System.out.printf("|%5d|%-15s|%-15s|%15s|%-30s|", idStudent,lastName,firstName,dateOfBirth, email);
        return true;
    }
}

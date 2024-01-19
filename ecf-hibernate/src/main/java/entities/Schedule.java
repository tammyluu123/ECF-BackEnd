package entities;

import javax.persistence.*;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_day_class", nullable = false)
    private int idDayClass;

    private String dayClass;
    private String hourClass;
    @ManyToOne
    private Student student;

    public Schedule() {
    }

    public Schedule(String dayClass, String hourClass) {
        this.dayClass = dayClass;
        this.hourClass = hourClass;
    }

    public Schedule(String dayClass, String hourClass, Student student) {
        this.dayClass = dayClass;
        this.hourClass = hourClass;
        this.student = student;
    }

    public int getIdDayClass() {
        return idDayClass;
    }

    public void setIdDayClass(int idDayClass) {
        this.idDayClass = idDayClass;
    }
}

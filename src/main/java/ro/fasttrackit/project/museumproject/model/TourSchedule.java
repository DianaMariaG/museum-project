package ro.fasttrackit.project.museumproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tour_schedule")
public class TourSchedule {
    @Id
    @GeneratedValue
    private int id;
    private String startDate;

    @OneToOne
    @JsonIgnore
    private Museum museum;

    public TourSchedule(){}

    public TourSchedule(String startDate, Museum museum) {
        this.startDate = startDate;
        this.museum = museum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    @Override
    public String toString() {
        return "TourSchedule{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", museum=" + museum +
                '}';
    }
}

package ro.fasttrackit.project.museumproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "open_days")
public class OpenDays {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public OpenDays(){}

    public OpenDays(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OpenDays{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

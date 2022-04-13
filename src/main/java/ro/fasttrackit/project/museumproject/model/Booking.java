package ro.fasttrackit.project.museumproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private String customerName;
    private double totalPrice;

    @OneToOne
    private Ticket ticket;

    @ManyToOne
    private Museum museum;

    @ManyToOne
    private TourSchedule tourSchedule;

    public Booking() {}

    public Booking(String ref, String customerName, double totalPrice,
                   Museum museum, TourSchedule tourSchedule, Ticket ticket) {
        this.ref = ref;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.museum = museum;
        this.tourSchedule = tourSchedule;
        this.ticket = ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Museum getMuseum() {
        return museum;
    }

    public void setMuseum(Museum museum) {
        this.museum = museum;
    }

    public TourSchedule getTourSchedule() {
        return tourSchedule;
    }

    public void setTourSchedule(TourSchedule tourSchedule) {
        this.tourSchedule = tourSchedule;
    }
}

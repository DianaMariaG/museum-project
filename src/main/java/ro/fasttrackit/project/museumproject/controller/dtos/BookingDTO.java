package ro.fasttrackit.project.museumproject.controller.dtos;

import ro.fasttrackit.project.museumproject.model.Museum;
import ro.fasttrackit.project.museumproject.model.Ticket;
import ro.fasttrackit.project.museumproject.model.TicketType;
import ro.fasttrackit.project.museumproject.model.TourSchedule;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

public class BookingDTO { //obiectul pe care il trimit la postman

    private String customerName;
    private Museum museum;
    private TourSchedule tourSchedule;
    private Ticket ticket;

    public BookingDTO(String customerName, Museum museum, TourSchedule tourSchedule, Ticket ticket) {

        this.customerName = customerName;
        this.museum = museum;
        this.tourSchedule = tourSchedule;
        this.ticket = ticket;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}

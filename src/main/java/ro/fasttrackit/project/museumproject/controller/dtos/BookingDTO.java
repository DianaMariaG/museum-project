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
    private List<Ticket> tickets;

    public BookingDTO(String customerName, Museum museum, TourSchedule tourSchedule, List<Ticket> tickets) {

        this.customerName = customerName;
        this.museum = museum;
        this.tourSchedule = tourSchedule;
        this.tickets = new ArrayList<>(tickets);
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}

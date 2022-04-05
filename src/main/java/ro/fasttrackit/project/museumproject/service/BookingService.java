package ro.fasttrackit.project.museumproject.service;

import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;
import ro.fasttrackit.project.museumproject.controller.dtos.BookingDTO;
import ro.fasttrackit.project.museumproject.model.Booking;
import ro.fasttrackit.project.museumproject.model.Ticket;
import ro.fasttrackit.project.museumproject.model.TicketType;
import ro.fasttrackit.project.museumproject.repository.BookingRepository;
import ro.fasttrackit.project.museumproject.repository.TicketRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;

    public BookingService(BookingRepository bookingRepository, TicketRepository ticketRepository) {
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<Booking> listBookings() {
       return bookingRepository.findAll();
    }

    public Optional<Booking> getBooking(Integer id) {
        return bookingRepository.findById(id);
    }

    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking(generateRandomRef(),
                bookingDTO.getCustomerName(), computeTotalPrice(bookingDTO.getTickets()),
                bookingDTO.getMuseum(), bookingDTO.getTourSchedule());
        bookingRepository.save(booking);
        for (Ticket t : bookingDTO.getTickets()) {
            t.setBooking(booking);
        }
        List<Ticket> savedTickets = ticketRepository.saveAll(bookingDTO.getTickets());
        booking.setTickets(savedTickets);
        return booking;
    }

    public String generateRandomRef() {
        RandomString rand = new RandomString();
        return rand.nextString();
    }

    public double computeTotalPrice(List<Ticket> tickets) {
        double totalPrice = 0;
        for (Ticket ticket: tickets) {
            totalPrice = totalPrice + ticket.getTicketType().getPrice() * ticket.getQuantity();
        }
        return totalPrice;
    }

    public Optional<Booking> delete(int id) {
        Optional<Booking> toDelete = bookingRepository.findById(id);
        toDelete.ifPresent(foundBooking -> bookingRepository.delete(foundBooking));
        return toDelete;
    }
}

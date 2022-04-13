package ro.fasttrackit.project.museumproject.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.project.museumproject.controller.dtos.BookingDTO;
import ro.fasttrackit.project.museumproject.controller.dtos.ViewBookingDTO;
import ro.fasttrackit.project.museumproject.model.Booking;
import ro.fasttrackit.project.museumproject.service.BookingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingApiController {
    private final BookingService bookingService;

    public BookingApiController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping()
    List<ViewBookingDTO> getAllBookings() {
        return this.convertBookingToViewBookingDTO(bookingService.listBookings());
    }

    @PostMapping()
    Booking createBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.createBooking(bookingDTO);
    }

    @DeleteMapping("/{id}")
    Booking deleteBooking(@PathVariable int id) {
        return bookingService.delete(id)
                .orElse(null);
    }
    private List<ViewBookingDTO> convertBookingToViewBookingDTO(List<Booking> bookings) {
        List<ViewBookingDTO> result = new ArrayList<>();
        for (Booking booking : bookings) {

            ViewBookingDTO viewBookingDTO = new ViewBookingDTO();
            viewBookingDTO.setId(booking.getId());
            viewBookingDTO.setCustomerName(booking.getCustomerName());
            viewBookingDTO.setRef(booking.getRef());
            viewBookingDTO.setTicketType(booking.getTicket().getTicketType().getName());
            viewBookingDTO.setTicketQuantity(booking.getTicket().getQuantity());
            viewBookingDTO.setScheduleStartDate(booking.getTourSchedule().getStartDate());
            viewBookingDTO.setPrice(booking.getTotalPrice());

            result.add(viewBookingDTO);
        }
        return result;
    }
}

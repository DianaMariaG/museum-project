package ro.fasttrackit.project.museumproject.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.project.museumproject.controller.dtos.BookingDTO;
import ro.fasttrackit.project.museumproject.model.Booking;
import ro.fasttrackit.project.museumproject.model.Museum;
import ro.fasttrackit.project.museumproject.model.TicketType;
import ro.fasttrackit.project.museumproject.model.TourSchedule;
import ro.fasttrackit.project.museumproject.service.BookingService;
import ro.fasttrackit.project.museumproject.service.MuseumService;
import ro.fasttrackit.project.museumproject.service.TicketTypeService;
import ro.fasttrackit.project.museumproject.service.TourScheduleService;

import java.util.List;

@RestController
@RequestMapping("api/museum")
public class MuseumApiController {
    private final MuseumService museumService;
    private final TicketTypeService ticketTypeService;
    private final TourScheduleService tourScheduleService;

    public MuseumApiController(MuseumService museumService, TicketTypeService ticketTypeService, TourScheduleService tourScheduleService) {
        this.museumService = museumService;
        this.ticketTypeService = ticketTypeService;
        this.tourScheduleService = tourScheduleService;
    }

    @GetMapping
    Museum getMuseums() {
        return museumService.getMuseums().get(0);
    }

    @GetMapping("/ticketTypes")
    List<TicketType> getAllTicketTypes() {
        return ticketTypeService.getAllTicketTypes();
    }


    @GetMapping("/tourSchedules")
    List<TourSchedule> getTourSchedules() {
        return tourScheduleService.getTourSchedule();
    }


}

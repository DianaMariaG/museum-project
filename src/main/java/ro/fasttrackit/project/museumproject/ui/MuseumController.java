//package ro.fasttrackit.project.museumproject.ui;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import ro.fasttrackit.project.museumproject.service.BookingService;
//import ro.fasttrackit.project.museumproject.service.MuseumService;
//import ro.fasttrackit.project.museumproject.service.TicketTypeService;
//import ro.fasttrackit.project.museumproject.service.TourScheduleService;
//
//@Controller
////@RequestMapping("museum")
public class MuseumController {
//    private final BookingService bookingService;
//    private final MuseumService museumService;
//    private final TicketTypeService ticketTypeService;
//    private final TourScheduleService tourScheduleService;
//
//    public MuseumController(BookingService bookingService, MuseumService museumService, TicketTypeService ticketTypeService, TourScheduleService tourScheduleService) {
//        this.bookingService = bookingService;
//        this.museumService = museumService;
//        this.ticketTypeService = ticketTypeService;
//        this.tourScheduleService = tourScheduleService;
//    }
//
//    @GetMapping
//    String getBookingPage(Model model, @RequestParam(required = false) Integer showMuseum) {
//        model.addAttribute("museum", museumService.getMuseums().get(0));
//        model.addAttribute("ticketTypes",ticketTypeService.getAllTicketTypes());
//        model.addAttribute("tourSchedules",tourScheduleService.getTourSchedule());
//        if(showMuseum != null) {
//            model.addAttribute("museumDetails", museumService.getMuseumById(showMuseum)
//                    .orElse(null));
//        }
//        return "museum";
//    }
}

package ro.fasttrackit.project.museumproject.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.project.museumproject.model.TicketType;
import ro.fasttrackit.project.museumproject.repository.TicketTypeRepository;

import java.util.List;

@Service
public class TicketTypeService {
    private final TicketTypeRepository ticketTypeRepository;

    public TicketTypeService(TicketTypeRepository ticketTypeRepository) {
        this.ticketTypeRepository = ticketTypeRepository;
    }

    public List<TicketType> getAllTicketTypes() {
        return ticketTypeRepository.findAll();
    }
}

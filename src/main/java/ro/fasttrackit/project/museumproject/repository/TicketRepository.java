package ro.fasttrackit.project.museumproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.project.museumproject.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}

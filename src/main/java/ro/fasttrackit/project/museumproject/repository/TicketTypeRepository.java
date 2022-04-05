package ro.fasttrackit.project.museumproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.project.museumproject.model.TicketType;

public interface TicketTypeRepository extends JpaRepository<TicketType, Integer> {
}

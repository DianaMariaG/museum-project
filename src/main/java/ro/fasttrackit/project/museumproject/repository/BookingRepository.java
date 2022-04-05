package ro.fasttrackit.project.museumproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.project.museumproject.model.Booking;

public interface BookingRepository extends JpaRepository <Booking, Integer> {
}

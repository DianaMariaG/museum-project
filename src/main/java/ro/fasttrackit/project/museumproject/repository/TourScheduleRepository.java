package ro.fasttrackit.project.museumproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.project.museumproject.model.TourSchedule;

public interface TourScheduleRepository extends JpaRepository<TourSchedule, Integer> {
}

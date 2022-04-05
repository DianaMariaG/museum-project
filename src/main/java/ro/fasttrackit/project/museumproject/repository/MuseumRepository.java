package ro.fasttrackit.project.museumproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.project.museumproject.model.Museum;

public interface MuseumRepository extends JpaRepository <Museum,Integer> {
}

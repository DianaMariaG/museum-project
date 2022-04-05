package ro.fasttrackit.project.museumproject.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.project.museumproject.model.Museum;
import ro.fasttrackit.project.museumproject.repository.MuseumRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MuseumService {
    private final MuseumRepository museumRepository;

    public MuseumService(MuseumRepository museumRepository) {
        this.museumRepository = museumRepository;
    }

    public List<Museum> getMuseums() {
        return museumRepository.findAll();
    }

    public Optional<Museum> getMuseumById(Integer id) {
        return museumRepository.findById(id);
    }
}

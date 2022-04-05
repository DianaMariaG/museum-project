package ro.fasttrackit.project.museumproject.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.project.museumproject.model.TourSchedule;
import ro.fasttrackit.project.museumproject.repository.TourScheduleRepository;

import java.util.List;

@Service
public class TourScheduleService {
    private final TourScheduleRepository tourScheduleRepository;

    public TourScheduleService(TourScheduleRepository tourScheduleRepository) {
        this.tourScheduleRepository = tourScheduleRepository;
    }

    public List<TourSchedule> getTourSchedule() {
        return tourScheduleRepository.findAll();
    }
}

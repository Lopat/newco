package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List <TripDto> findAll() {
        return tripRepository.findAll();
    }

    public TripDto findById(Long id) throws Exception {
        return tripRepository.findById(id)
                             .orElseThrow(() -> new Exception("NO TRIP"));
    }

    public void save(TripDto trip) {
        tripRepository.save(trip);
    }

    public void delete(Long id) {
        tripRepository.deleteById(id);
    }

    public void update(TripDto newTrip) {
        tripRepository.saveAndFlush(newTrip);
    }
}

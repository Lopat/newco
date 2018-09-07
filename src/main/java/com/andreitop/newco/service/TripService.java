package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.Repository;
import com.andreitop.newco.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService extends com.andreitop.newco.service.Service<TripDto> {

    @Autowired
    public TripService(@Qualifier("tripRepository") Repository<TripDto> repo) {
        super(repo);
    }

    TripService() {}
}

package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TripServiceTest {

    private List <TripDto> testList;
    @Autowired private TripService tripService;
    @MockBean private TripRepository tripRepository;

    @Before
    public void setUp() {

        TripDto trip = new TripDto();
        trip.setId(1L);
        trip.setDestination("DES");
        trip.setOrigin("ORI");
        trip.setPrice(123);
        testList = Collections.singletonList(trip);
    }

    @Test
    public void save() {
        tripService.save(testList.get(0));
        verify(tripRepository, times(1)).save(testList.get(0));
    }

    @Test
    public void update() {
        tripService.update(testList.get(0));
        verify(tripRepository, times(1)).update(testList.get(0));
    }

    @Test
    public void deleteById() {
        tripService.deleteById(1L);
        verify(tripRepository, times(1)).deleteById(1L);
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
    }
}
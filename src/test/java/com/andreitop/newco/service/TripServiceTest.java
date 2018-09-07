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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
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

        TripDto expected = new TripDto(1L, "ORI", "DES", 123);
        given(tripRepository.findById(1L)).willReturn(expected);

        TripDto resultTrip = tripService.findById(1L);
        assertEquals(of(1L), ofNullable(resultTrip.getId()));
        assertEquals("ORI", resultTrip.getOrigin());
        assertEquals("DES", resultTrip.getDestination());
        assertEquals(of(123), ofNullable(resultTrip.getPrice()));
    }

    @Test
    public void findAll() {

        List<TripDto> newList = new ArrayList <>();
        newList.add(new TripDto(2L, "ORI2", "DES2", 123));
        newList.add(new TripDto(3L, "ORI3", "DES3", 123));
        newList.add(new TripDto(4L, "ORI4", "DES4", 123));
        given(tripRepository.findAll()).willReturn(newList);

        List<TripDto> tripServiceAll = tripService.findAll();
        assertEquals(3, tripServiceAll.size());
    }
}
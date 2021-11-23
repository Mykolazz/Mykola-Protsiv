package com.travel.agency.protsiv.repository;

import com.travel.agency.protsiv.dto.TourDto;
import com.travel.agency.protsiv.model.Tour;

import java.util.List;

public interface TourRepository {

    Tour saveTour(Tour tour);

    void deleteById(Integer id);

    List<Tour> getAllTours();

    Tour getTourById(Integer id);

    Tour updateTour(Integer id, TourDto tourDto);
}

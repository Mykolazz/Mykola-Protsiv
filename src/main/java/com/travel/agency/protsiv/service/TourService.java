package com.travel.agency.protsiv.service;

import com.travel.agency.protsiv.dto.TourDto;

import java.util.List;

public interface TourService {
    TourDto saveTour(TourDto tourDto);

    void deleteTourById(Integer id);

    List<TourDto> getAllTours();

    TourDto getTourById(Integer id);

    TourDto updateTour(Integer id, TourDto tourDto);
}

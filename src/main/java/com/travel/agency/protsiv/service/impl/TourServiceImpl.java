package com.travel.agency.protsiv.service.impl;

import com.travel.agency.protsiv.dto.TourDto;
import com.travel.agency.protsiv.model.Tour;
import com.travel.agency.protsiv.repository.TourRepository;
import com.travel.agency.protsiv.service.TourService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    @Override
    public TourDto saveTour(TourDto tourDto) {
        log.info("create order with id {}", tourDto.getId());
        Tour tour = mapTourDtoToTour(tourDto);
        tour = tourRepository.saveTour(tour);
        return mapTourToTourDto(tour);
    }

    @Override
    public void deleteTourById(Integer id) {
        if(id!=null) {
            log.info("delete tour with id {}", id);
            tourRepository.deleteById(id);
        }
    }

    @Override
    public List<TourDto> getAllTours() {
        log.info("get all tours");
        return tourRepository.getAllTours().stream()
                .map(this::mapTourToTourDto)
                .collect(Collectors.toList());
    }

    @Override
    public TourDto getTourById(Integer id) {
        log.info("get tour by id {}", id);
        if(id==null) {
            return null;
        }else
            return mapTourToTourDto(tourRepository.getTourById(id));
    }

    @Override
    public TourDto updateTour(Integer id, TourDto tourDto) {
        return mapTourToTourDto(tourRepository.updateTour(id, tourDto));
    }

    private TourDto mapTourToTourDto(Tour tour) {
        return TourDto.builder()
                .id(tour.getId())
                .title(tour.getTitle())
                .description(tour.getDescription())
                .numberOfPerson(tour.getNumberOfPerson())
                .price(tour.getPrice())
                .rating(tour.getRating())
                .build();
    }

    private Tour mapTourDtoToTour(TourDto tourDto) {
        return Tour.builder()
                .id(tourDto.getId())
                .title(tourDto.getTitle())
                .description(tourDto.getDescription())
                .numberOfPerson(tourDto.getNumberOfPerson())
                .price(tourDto.getPrice())
                .rating(tourDto.getRating())
                .build();
    }
}

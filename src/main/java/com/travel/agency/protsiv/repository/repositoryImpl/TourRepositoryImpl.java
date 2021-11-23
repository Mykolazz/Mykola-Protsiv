package com.travel.agency.protsiv.repository.repositoryImpl;

import com.travel.agency.protsiv.dto.TourDto;
import com.travel.agency.protsiv.model.Tour;
import com.travel.agency.protsiv.repository.TourRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TourRepositoryImpl implements TourRepository {

    private final List<Tour> tours = new ArrayList<>();

    @Override
    public Tour saveTour(Tour tour) {
        tour.setId(tours.size());
        tours.add(tour);
        return tour;
    }

    @Override
    public void deleteById(Integer id) {
        tours.removeIf(t -> t.getId().equals(id));
    }

    @Override
    public List<Tour> getAllTours() {
        return new ArrayList<>(tours);
    }

    @Override
    public Tour getTourById(Integer id) {
        return tours.stream()
                .filter(tour -> tour.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tour is not found!"));
    }

    @Override
    public Tour updateTour(Integer id, TourDto tourDto) {
        Tour tour = tours.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tour is not found!"));
        tour.setId(tourDto.getId());
        tour.setTitle(tourDto.getTitle());
        tour.setDescription(tourDto.getDescription());
        tour.setNumberOfPerson(tourDto.getNumberOfPerson());
        tour.setPrice(tourDto.getPrice());
        tour.setRating(tourDto.getRating());

        return tour;
    }
}

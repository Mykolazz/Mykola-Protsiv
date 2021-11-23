package com.travel.agency.protsiv.controller;

import com.travel.agency.protsiv.dto.TourDto;
import com.travel.agency.protsiv.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tours")
public class TourController {

    private final TourService tourService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findAll")
    public List<TourDto> getToursList() {
        return tourService.getAllTours();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/tour/{id}")
    public TourDto getTour(@PathVariable Integer id) {
        return tourService.getTourById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/tour")
    public TourDto createTour(@RequestBody TourDto tourDto) {
        return tourService.saveTour(tourDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/tour/{id}")
    public TourDto updateTour(@PathVariable Integer id, @RequestBody TourDto tourDto) {
        return tourService.updateTour(id, tourDto);
    }

    @DeleteMapping(value = "/tour/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Integer id) {
        tourService.deleteTourById(id);
        return ResponseEntity.noContent().build();
    }
}

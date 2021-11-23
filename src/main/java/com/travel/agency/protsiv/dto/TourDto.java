package com.travel.agency.protsiv.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TourDto {
    private Integer id;
    private String title;
    private String description;
    private int numberOfPerson;
    private double price;
    private double rating;
}

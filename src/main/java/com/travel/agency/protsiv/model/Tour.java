package com.travel.agency.protsiv.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.sql.Timestamp;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Tour extends Model {

    private Integer id;
    private String title;
    private String description;
    private int numberOfPerson;
    // private int hot;
    private double price;
    // private int enableQuantity;
    private double rating;
    // private int feedback_count;
    // private int discount;
    // private Timestamp lastUpdate;

}

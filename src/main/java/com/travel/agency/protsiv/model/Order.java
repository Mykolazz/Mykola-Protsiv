package com.travel.agency.protsiv.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Order extends Model {

    private Integer id;
    private Integer userId;
    private Integer tourId;
    private Double price;
    // status == 0 - unpaid order in basket; status == 1 - payment created, 
    // waiting for confirmation; status == 2 - order payment confirmed.
    private Integer status;
    /*
    private Date creationDate;
    private Timestamp lastUpdate;

     */
}

package com.travel.agency.protsiv.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Payment extends Model {

    private Integer id;
    private double amount;
    private String comment;
    private int orderId;
    /*
    private int orderTourId;
    private int orderUserId;
    private Date creationDate;
    private Timestamp lastUpdate;
    */
}

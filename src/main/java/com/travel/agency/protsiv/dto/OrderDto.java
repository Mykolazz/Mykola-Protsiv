package com.travel.agency.protsiv.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
    private Integer id;
    private Double price;
    // status == 0 - unpaid order in basket; status == 1 - payment created,
    // waiting for confirmation; status == 2 - order payment confirmed.
    private Integer status;
}

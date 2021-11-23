package com.travel.agency.protsiv.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDto {
    private Integer id;
    private double amount;
    private String comment;
}

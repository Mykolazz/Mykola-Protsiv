package com.travel.agency.protsiv.service;

import com.travel.agency.protsiv.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    PaymentDto savePayment(PaymentDto paymentDto);

    void deletePaymentById(Integer id);

    List<PaymentDto> getAllPayments();

    PaymentDto getPaymentById(Integer id);

    PaymentDto updatePayment(Integer id, PaymentDto paymentDto);
}

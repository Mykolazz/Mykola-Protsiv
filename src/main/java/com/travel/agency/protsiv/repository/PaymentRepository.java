package com.travel.agency.protsiv.repository;

import com.travel.agency.protsiv.dto.PaymentDto;
import com.travel.agency.protsiv.model.Payment;

import java.util.List;

public interface PaymentRepository {

    Payment savePayment(Payment payment);

    void deletePaymentById(Integer id);

    List<Payment> getAllPayments();

    Payment getPaymentById(Integer id);

    Payment updatePayment(Integer id, PaymentDto paymentDto);
}

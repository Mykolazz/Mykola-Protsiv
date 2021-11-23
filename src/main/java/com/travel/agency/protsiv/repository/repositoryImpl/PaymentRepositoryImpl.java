package com.travel.agency.protsiv.repository.repositoryImpl;

import com.travel.agency.protsiv.dto.PaymentDto;
import com.travel.agency.protsiv.model.Payment;
import com.travel.agency.protsiv.repository.PaymentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private final List<Payment> payments = new ArrayList<>();

    @Override
    public Payment savePayment(Payment payment) {
        payment.setId(payments.size());
        payments.add(payment);
        return payment;
    }

    @Override
    public void deletePaymentById(Integer id) {
        payments.removeIf(o -> o.getId().equals(id));
    }

    @Override
    public List<Payment> getAllPayments() {
        return new ArrayList<>(payments);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return payments.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Payment is not found!"));
    }

    @Override
    public Payment updatePayment(Integer id, PaymentDto paymentDto) {
        Payment payment = payments.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Payment is not found!"));
        payment.setId(paymentDto.getId());
        payment.setAmount(paymentDto.getAmount());
        payment.setComment(paymentDto.getComment());

        return payment;
    }

}

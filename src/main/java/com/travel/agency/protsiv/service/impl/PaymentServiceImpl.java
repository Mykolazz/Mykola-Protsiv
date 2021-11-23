package com.travel.agency.protsiv.service.impl;

import com.travel.agency.protsiv.dto.PaymentDto;
import com.travel.agency.protsiv.model.Payment;
import com.travel.agency.protsiv.repository.PaymentRepository;
import com.travel.agency.protsiv.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentDto savePayment(PaymentDto paymentDto) {
        log.info("create payment with id {}", paymentDto.getId());
        Payment payment = mapPaymentDtoToPayment(paymentDto);
        payment = paymentRepository.savePayment(payment);
        return mapPaymentToPaymentDto(payment);
    }

    @Override
    public void deletePaymentById(Integer id) {
        if(id!=null) {
            log.info("delete payment with id {}", id);
            paymentRepository.deletePaymentById(id);
        }
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        log.info("get all payments");
        return paymentRepository.getAllPayments().stream()
                .map(this::mapPaymentToPaymentDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDto getPaymentById(Integer id) {
        log.info("get payment by id {}", id);
        if(id==null) {
            return null;
        }else
            return mapPaymentToPaymentDto(paymentRepository.getPaymentById(id));
    }

    @Override
    public PaymentDto updatePayment(Integer id, PaymentDto paymentDto) {
        return mapPaymentToPaymentDto(paymentRepository.updatePayment(id, paymentDto));
    }

    private PaymentDto mapPaymentToPaymentDto(Payment payment) {
        return PaymentDto.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .comment(payment.getComment())
                .build();
    }

    private Payment mapPaymentDtoToPayment(PaymentDto paymentDto) {
        return Payment.builder()
                .id(paymentDto.getId())
                .amount(paymentDto.getAmount())
                .comment(paymentDto.getComment())
                .build();
    }
}

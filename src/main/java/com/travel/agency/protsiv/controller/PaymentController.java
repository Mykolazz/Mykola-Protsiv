package com.travel.agency.protsiv.controller;

import com.travel.agency.protsiv.dto.PaymentDto;
import com.travel.agency.protsiv.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findAll")
    public List<PaymentDto> getPaymentsList() {
        return paymentService.getAllPayments();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/payment/{id}")
    public PaymentDto getPayment(@PathVariable Integer id) {
        return paymentService.getPaymentById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/payment")
    public PaymentDto createPayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.savePayment(paymentDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/payment/{id}")
    public PaymentDto updatePayment(@PathVariable Integer id, @RequestBody PaymentDto paymentDto) {
        return paymentService.updatePayment(id, paymentDto);
    }

    @DeleteMapping(value = "/payment/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Integer id) {
        paymentService.deletePaymentById(id);
        return ResponseEntity.noContent().build();
    }
}

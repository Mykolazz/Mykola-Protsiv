package com.travel.agency.protsiv.controller;

import com.travel.agency.protsiv.dto.OrderDto;
import com.travel.agency.protsiv.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findAll")
    public List<OrderDto> getOrdersList() {
        return orderService.getAllOrders();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/order/{id}")
    public OrderDto getOrder(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/order")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/order/{id}")
    public OrderDto updateOrder(@PathVariable Integer id, @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }

}

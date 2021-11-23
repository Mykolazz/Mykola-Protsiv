package com.travel.agency.protsiv.service;


import com.travel.agency.protsiv.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto saveOrder(OrderDto orderDto);

    void deleteOrderById(Integer id);

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(Integer id);

    OrderDto updateOrder(Integer id, OrderDto orderDto);
}

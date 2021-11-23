package com.travel.agency.protsiv.repository;

import com.travel.agency.protsiv.dto.OrderDto;
import com.travel.agency.protsiv.model.Order;

import java.util.List;

public interface OrderRepository {

    Order saveOrder(Order order);

    void deleteById(Integer id);

    List<Order> getAll();

    Order getOrderById(Integer id);

    Order updateOrder(Integer id, OrderDto orderDto);
}

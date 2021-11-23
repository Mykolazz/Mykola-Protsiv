package com.travel.agency.protsiv.repository.repositoryImpl;

import com.travel.agency.protsiv.dto.OrderDto;
import com.travel.agency.protsiv.repository.OrderRepository;
import com.travel.agency.protsiv.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    @Override
    public Order saveOrder(Order order) {
        order.setId(orders.size());
        orders.add(order);
        return order;
    }

    @Override
    public void deleteById(Integer id) {
        orders.removeIf(o -> o.getId().equals(id));
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orders.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order is not found!"));
    }

    @Override
    public Order updateOrder(Integer id, OrderDto orderDto) {

        Order order = orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order is not found!"));
        order.setPrice(orderDto.getPrice());
        order.setStatus(orderDto.getStatus());

        return order;
    }
}

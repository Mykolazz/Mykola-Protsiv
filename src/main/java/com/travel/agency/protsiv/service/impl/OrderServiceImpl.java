package com.travel.agency.protsiv.service.impl;

import com.travel.agency.protsiv.dto.OrderDto;
import com.travel.agency.protsiv.model.Order;
import com.travel.agency.protsiv.repository.OrderRepository;
import com.travel.agency.protsiv.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        log.info("create order with id {}", orderDto.getId());
        Order order = mapOrderDtoToOrder(orderDto);
        order = orderRepository.saveOrder(order);
        return mapOrderToOrderDto(order);
    }

    @Override
    public void deleteOrderById(Integer id) {
        if(id!=null) {
            log.info("delete order with id {}", id);
            orderRepository.deleteById(id);
        }
    }

    @Override
    public List<OrderDto> getAllOrders() {
        log.info("get all orders");
        return orderRepository.getAll().stream()
                .map(this::mapOrderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Integer id) {
        log.info("get order by id {}", id);
        if(id==null) {
            return null;
        }else
            return mapOrderToOrderDto(orderRepository.getOrderById(id));
    }

    @Override
    public OrderDto updateOrder(Integer id, OrderDto orderDto){
        return mapOrderToOrderDto(orderRepository.updateOrder(id, orderDto));
    }

    private OrderDto mapOrderToOrderDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .price(order.getPrice())
                .status(order.getStatus())
                .build();
    }

    private Order mapOrderDtoToOrder(OrderDto orderDto) {
        return Order.builder()
                .id(orderDto.getId())
                .price(orderDto.getPrice())
                .status(orderDto.getStatus())
                .build();
    }

}

package za.co.absa.api.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import za.co.absa.api.bookstore.model.Order;
import za.co.absa.api.bookstore.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Mono<Order> createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Flux<Order> getOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "oderTimeStamp"));
    }
}

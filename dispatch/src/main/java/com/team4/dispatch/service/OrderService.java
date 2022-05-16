package com.team4.dispatch.service;

import com.team4.dispatch.model.Order;
import com.team4.dispatch.repository.OrderRepository;

@Service
public class OrderService {
  private OrderRepository orderRepository;
  private Order order;

  @Autowired
  public OrderService(OrderRepository orderRepository, Order order) {
    this.orderRepository = orderRepository;
    this.order = order;
  }

  public void add(Order order) {
    orderRepository.save(order);
  }

  @Transactional(isolation = Isolation.SERIALIZABLE)
  public void deleteOrder(Long orderId) throws OrderNotExistException {
    Order order = orderRepository.findById(orderId);
    if (order == null) {
      throw new OrderNotExistException("Order doesn't exist");
    }
    orderRepository.deleteById(orderId);
  }
}
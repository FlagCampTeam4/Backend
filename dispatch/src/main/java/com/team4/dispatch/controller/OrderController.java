package com.team4.dispatch.controller;

import com.team4.dispatch.model.Order;
import com.team4.dispatch.model.User;
import com.team4.dispatch.service.OrderService;
import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class OrderController {
  private OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping("/order")
  public void addOrder(
      @RequestParam("weight") int weight,
      @RequestParam("length") int length,
      @RequestParam("width") int width,
      @RequestParam("height") int height,
      @RequestParam("total_price") int totalPrice,
      @RequestParam("pick_up_address") String pickUpAddress,
      @RequestParam("delivery_address") String deliveryAddress,
      @RequestParam("pick_up_time") LocalDateTime pickUpTime,
      @RequestParam("delivery_time") LocalDateTime deliveryTime,
      @RequestParam("order_status") int orderStatus,
      Principal principal
  ) {
    Order order = new Order.Builder()
        .setWeight(weight)
        .setLength(length)
        .setWidth(width)
        .setHeight(height)
        .setTotalPrice(totalPrice)
        .setPickUpAddress(pickUpAddress)
        .setDeliveryAddress(deliveryAddress)
        .setPickUpTime(pickUpTime)
        .setDeliveryTime(deliveryTime)
        .setOrderStatus(orderStatus)
        .setUsername(new User.Builder().setUsername(principal.getName()).build())
        .build();
    orderService.add(order);

  }
}

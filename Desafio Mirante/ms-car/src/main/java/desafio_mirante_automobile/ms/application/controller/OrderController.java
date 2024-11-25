package desafio_mirante_automobile.ms.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_mirante_automobile.ms.infra.service.OrderService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/order")
public class OrderController {
  
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
      this.orderService = orderService;
  }

  @PostMapping("/create/{id}")
  public CarInfoDTO create(@PathVariable Long id) {
      return orderService.createOrder(id);
  }

  @PostMapping("/all")
  public String getAll(@RequestBody String entity) {
      return entity;
  }
}

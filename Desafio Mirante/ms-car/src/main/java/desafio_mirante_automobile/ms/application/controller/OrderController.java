package desafio_mirante_automobile.ms.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_mirante_automobile.ms.application.dto.CarInfoDTO;
import desafio_mirante_automobile.ms.application.dto.OrderDTO;
import desafio_mirante_automobile.ms.application.dto.RequestDTO;
import desafio_mirante_automobile.ms.infra.service.OrderService;

import java.util.List;

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

  @PostMapping("/create")
  public OrderDTO create(@RequestBody RequestDTO dto) {
      return orderService.createOrder(dto);
  }

  @PostMapping("/all")
  public List<OrderDTO> getAll() {
     return orderService.getAll();
  }
}

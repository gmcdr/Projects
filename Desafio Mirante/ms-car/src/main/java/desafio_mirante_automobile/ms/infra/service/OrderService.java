package desafio_mirante_automobile.ms.infra.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import desafio_mirante_automobile.ms.application.dto.CarInfoDTO;
import desafio_mirante_automobile.ms.infra.repository.OrderRepository;

@Service
public class OrderService {
  
  private OrderRepository orderRepository;
  private static final String URL = "http://localhost:8081/car/";
  
  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public CarInfoDTO createOrder(Long carCode) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getForObject(URL + carCode, CarInfoDTO.class);
    //CarInfoDTO carInfo = restTemplate.getForObject("http://localhost:8081/car/" + carCode, CarInfoDTO.class);
    return restTemplate.getForObject(URL + carCode, CarInfoDTO.class);
  }


}

package desafio_mirante_automobile.ms.infra.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import desafio_mirante_automobile.ms.application.dto.CarDTO;
import desafio_mirante_automobile.ms.application.dto.CarInfoDTO;
import desafio_mirante_automobile.ms.application.dto.OrderDTO;
import desafio_mirante_automobile.ms.application.dto.RequestDTO;
import desafio_mirante_automobile.ms.infra.repository.OrderRepository;

@Service
public class OrderService {
  
  private OrderRepository orderRepository;
  private static final String URL = "http://localhost:8081/car/";
  
  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public OrderDTO createOrder(RequestDTO dto) {
    RestTemplate restTemplate = new RestTemplate();
     CarInfoDTO carInfo = restTemplate.getForObject(URL + "/" +  dto.getCarId(), CarInfoDTO.class);
     CarDTO car = CarDTO.builder()
         .carInfo(carInfo)
         .optionalFeatures(dto.getOptionalFeatures())
         .build();
    if (carInfo != null) {
      OrderDTO result = OrderDTO.builder()
          .car(car)
          .build();

          return result;
      }
  return null;
  }
}

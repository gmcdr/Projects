package desafio_mirante_automobile.ms.infra.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import desafio_mirante_automobile.ms.application.dto.CarDTO;
import desafio_mirante_automobile.ms.application.dto.CarInfoDTO;
import desafio_mirante_automobile.ms.application.dto.OrderDTO;
import desafio_mirante_automobile.ms.application.dto.RequestDTO;
import desafio_mirante_automobile.ms.infra.persistence.CarEntity;
import desafio_mirante_automobile.ms.infra.persistence.OptionalFeatureEntity;
import desafio_mirante_automobile.ms.infra.persistence.OrderEntity;
import desafio_mirante_automobile.ms.infra.repository.OptionalFeatureRepository;
import desafio_mirante_automobile.ms.infra.repository.OrderRepository;

@Service
public class OrderService {
  
  private OrderRepository orderRepository;
  private OptionalFeatureRepository optionalFeatureRepository;

  private static final String URL = "http://localhost:8081/car/";
  
  public OrderService(OrderRepository orderRepository, OptionalFeatureRepository optionalFeatureRepository) {
    this.orderRepository = orderRepository;
    this.optionalFeatureRepository = optionalFeatureRepository;
  }

  public OrderDTO createOrder(RequestDTO dto) {
    RestTemplate restTemplate = new RestTemplate();
     CarInfoDTO carInfo = restTemplate.getForObject(URL + "/" +  dto.getCarId(), CarInfoDTO.class);
     CarDTO car = CarDTO.builder()
         .carInfo(carInfo)
         .optionalFeatures(dto.getOptionalFeatures())
         .build();
    if (carInfo != null) {
          List<Double> prices = new ArrayList<>();
          for (Long id : dto.getOptionalFeatures()) {
            OptionalFeatureEntity optionalFeature = optionalFeatureRepository.findById(id).get();
            prices.add(optionalFeature.getPrice());
          }
          return  OrderDTO.builder()
          .car(car)
          .finalPrice(calculateFinalPrice(prices, carInfo.getPrice()))
          .build();
      }
      saveOrder(OrderDTO.builder().car(car).build());
    return null;
  }

  public OrderDTO saveOrder(OrderDTO orderDTO) {
    OrderEntity orderEntity = orderRepository.save(toEntity(orderDTO));
    return toDTO(orderEntity);
  }

  public OrderDTO toDTO(OrderEntity orderEntity) {
    return OrderDTO.builder()
        .car(toCarDTO(orderEntity.getCar()))
        .build();
  }

  public CarDTO toCarDTO(CarEntity carEntity) {
    return CarDTO.builder()
        .carInfo(CarInfoDTO.builder()
            .carname(carEntity.getName())
            .brand(carEntity.getBrand())
            .model(carEntity.getModel())
            .caryear(String.valueOf(carEntity.getYear()))
            .color(carEntity.getColor())
            .price(carEntity.getPrice().doubleValue())
            .cardescription(carEntity.getDescription())
            .build())
        .build();
  }

  public OrderEntity toEntity(OrderDTO orderDTO) {
    return OrderEntity.builder()
        .car(toCarEntity(orderDTO.getCar()))
        .build();
  }

  public CarEntity toCarEntity(CarDTO carDTO) {
    return CarEntity.builder()
        .name(carDTO.getCarInfo().getCarname())
        .brand(carDTO.getCarInfo().getBrand())
        .model(carDTO.getCarInfo().getModel())
        .year(Integer.parseInt(carDTO.getCarInfo().getCaryear()))
        .color(carDTO.getCarInfo().getColor())
        .price(BigDecimal.valueOf(carDTO.getCarInfo().getPrice()))
        .description(carDTO.getCarInfo().getCardescription())
        .build();
  }

  public Double calculateFinalPrice(List<Double> prices, Double carPrice) {
    Double finalPrice = 0.0;
    for (Double price : prices) {
      finalPrice += price;
    }
    return finalPrice + carPrice;
  }
}

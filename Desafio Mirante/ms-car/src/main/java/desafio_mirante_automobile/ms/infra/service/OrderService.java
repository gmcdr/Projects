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
        CarInfoDTO carInfo = restTemplate.getForObject(URL + "/" + dto.getCarId(), CarInfoDTO.class);

        if (carInfo != null) {
            List<Double> prices = new ArrayList<>();
            for (Long id : dto.getOptionalFeatures()) {
                OptionalFeatureEntity optionalFeature = optionalFeatureRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Optional feature not found: " + id));
                prices.add(optionalFeature.getPrice());
            }

            CarDTO car = CarDTO.builder()
                .carInfo(carInfo)
                .optionalFeatures(dto.getOptionalFeatures())
                .build();

            OrderDTO orderDTO = OrderDTO.builder()
                .car(car)
                .finalPrice(calculateFinalPrice(prices, carInfo.getPrice()))
                .build();

            return saveOrder(orderDTO);
        }

        throw new RuntimeException("Car information not found");
    }

    public OrderDTO saveOrder(OrderDTO orderDTO) {
        OrderEntity orderEntity = toEntity(orderDTO);
        orderEntity = orderRepository.save(orderEntity);
        return toDTO(orderEntity);
    }

    public OrderDTO toDTO(OrderEntity orderEntity) {
        return OrderDTO.builder()
            .car(toCarDTO(orderEntity.getCar()))
            .finalPrice(orderEntity.getFinalprice())
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
        CarEntity carEntity = toCarEntity(orderDTO.getCar());
        OrderEntity orderEntity = OrderEntity.builder()
            .car(carEntity)
            .finalprice(orderDTO.getFinalPrice())
            .build();

        carEntity.setOrder(orderEntity);
        return orderEntity;
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

    public BigDecimal calculateFinalPrice(List<Double> prices, Double carPrice) {
        return prices.stream()
            .map(BigDecimal::valueOf)
            .reduce(BigDecimal.valueOf(carPrice), BigDecimal::add);
    }
}

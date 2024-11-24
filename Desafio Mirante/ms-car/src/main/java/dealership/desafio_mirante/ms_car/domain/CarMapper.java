package dealership.desafio_mirante.ms_car.domain;

import dealership.desafio_mirante.ms_car.infra.persistence.CarEntity;

public class CarMapper {

  private CarMapper() {}

    public static CarEntity toEntity(Car car) {
        CarEntity entity = new CarEntity();
        entity.setId(car.getId());
        entity.setName(car.getName());
        entity.setBrand(car.getBrand());
        entity.setModel(car.getModel());
        entity.setYear(car.getYear());
        entity.setColor(car.getColor());
        entity.setPrice(car.getPrice());
        entity.setDescription(car.getDescription());
        return entity;
    }

    public static Car toDomain(CarEntity entity) {
        return new Car.Builder()
                .id(entity.getId())
                .name(entity.getName())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .year(entity.getYear())
                .color(entity.getColor())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .build();
    }
}

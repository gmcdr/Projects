package dealership.desafio_mirante.ms_car.domain;

import dealership.desafio_mirante.ms_car.infra.persistence.CarEntity;

public class CarMapper {

  private CarMapper() {}

    public static CarEntity toEntity(Car car) {
        CarEntity entity = new CarEntity();
        entity.setCarname(car.getcarName());
        entity.setBrand(car.getBrand());
        entity.setModel(car.getModel());
        entity.setCaryear(car.getcarYear());
        entity.setColor(car.getColor());
        entity.setPrice(car.getPrice());
        entity.setCardescription(car.getcarDescription());
        return entity;
    }

    public static Car toDomain(CarEntity entity) {
        return new Car.Builder()
                .carName(entity.getCarname())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .carYear(entity.getCaryear())
                .color(entity.getColor())
                .price(entity.getPrice())
                .carDescription(entity.getCardescription())
                .build();
    }
}

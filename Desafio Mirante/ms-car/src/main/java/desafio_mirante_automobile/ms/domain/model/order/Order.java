package desafio_mirante_automobile.ms.domain.model.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import desafio_mirante_automobile.ms.domain.model.car.Car;

public class Order {

    private Car car;
    private BigDecimal finalprice;
    private LocalDateTime orderDate;
  
    public Order(Car car, BigDecimal finalprice) {
        this.car = car;
        this.finalprice = finalprice;
        this.orderDate = LocalDateTime.now();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public BigDecimal getFinalprice() {
        return finalprice;
    }

    public void setFinalprice(BigDecimal finalprice) {
        this.finalprice = finalprice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void calulateFinalPrice() {
        BigDecimal finalPrice = new BigDecimal(0);
        for (int i = 0; i < car.getOptionalFeatures().size(); i++) {
            finalPrice = finalPrice.add(new BigDecimal(car.getOptionalFeatures().get(i).getPrice()));
        }
        finalPrice = finalPrice.add(new BigDecimal(car.getCarInfo().getPrice()));
        this.finalprice = finalPrice;
    }

}

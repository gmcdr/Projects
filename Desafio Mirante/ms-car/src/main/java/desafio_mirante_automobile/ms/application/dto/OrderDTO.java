package desafio_mirante_automobile.ms.application.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
  
  CarDTO car;
  BigDecimal finalPrice;

  public OrderDTO toEntity() {
    return OrderDTO.builder()
        .car(this.car)
        .finalPrice(this.finalPrice)
        .build();
  }
}

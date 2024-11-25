package desafio_mirante_automobile.ms.application.dto;

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
  double finalPrice;

  public OrderDTO toEntity() {
    return OrderDTO.builder()
        .car(this.car)
        .finalPrice(this.finalPrice)
        .build();
  }
}

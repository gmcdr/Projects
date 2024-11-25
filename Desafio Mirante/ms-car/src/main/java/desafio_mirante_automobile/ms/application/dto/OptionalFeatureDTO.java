package desafio_mirante_automobile.ms.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionalFeatureDTO {

  private String name;
  private double price;
  
}

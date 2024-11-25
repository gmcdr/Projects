package dealership.desafio_mirante.ms_car.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

  private Long id;
  private String carname;
  private String brand;
  private String model;
  private String caryear;
  private String color;
  private String price;
  private String cardescription;
  
}

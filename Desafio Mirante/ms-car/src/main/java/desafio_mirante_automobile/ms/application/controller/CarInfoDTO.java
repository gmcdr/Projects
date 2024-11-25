package desafio_mirante_automobile.ms.application.controller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarInfoDTO {

  private Long id;
  private String name;
  private String brand;
  private String model;
  private String year;
  private String color;
  private String price;
  private String description;
  
}

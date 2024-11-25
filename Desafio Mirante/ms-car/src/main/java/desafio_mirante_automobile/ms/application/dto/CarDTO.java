package desafio_mirante_automobile.ms.application.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import desafio_mirante_automobile.ms.application.controller.CarInfoDTO;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

  List<OptionalFeatureDTO> optionalFeatures;
  CarInfoDTO carInfo;
}

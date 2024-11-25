package desafio_mirante_automobile.ms.application.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequestDTO {
  private Long carId;
  private List<Long> optionalFeatures;
}

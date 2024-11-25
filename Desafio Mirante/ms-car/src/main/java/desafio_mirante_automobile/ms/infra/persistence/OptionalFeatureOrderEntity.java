package desafio_mirante_automobile.ms.infra.persistence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "optional_feature_order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionalFeatureOrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private Long optionalFeatureId;
  private Long orderId;
  private Long carId;
  
}

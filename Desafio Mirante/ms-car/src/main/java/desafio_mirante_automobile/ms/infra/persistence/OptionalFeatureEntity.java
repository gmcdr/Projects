package desafio_mirante_automobile.ms.infra.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "optional_feature")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionalFeatureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private BigDecimal price;
}

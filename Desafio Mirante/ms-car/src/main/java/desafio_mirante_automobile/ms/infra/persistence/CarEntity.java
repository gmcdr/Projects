package desafio_mirante_automobile.ms.infra.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "car")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String brand;
    private String model;
    private int year;
    private String color;
    private BigDecimal price;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id")
    private List<OptionalFeatureEntity> optionalFeatures;
}

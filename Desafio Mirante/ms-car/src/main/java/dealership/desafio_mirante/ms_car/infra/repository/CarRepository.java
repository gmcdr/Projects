package dealership.desafio_mirante.ms_car.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dealership.desafio_mirante.ms_car.infra.persistence.CarEntity;

public interface CarRepository extends JpaRepository <CarEntity, Long> {}

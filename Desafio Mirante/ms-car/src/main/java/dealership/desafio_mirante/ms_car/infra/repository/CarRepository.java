package dealership.desafio_mirante.ms_car.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dealership.desafio_mirante.ms_car.domain.Car;

public interface CarRepository extends JpaRepository <Car, Long> {}

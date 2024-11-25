package desafio_mirante_automobile.ms.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import desafio_mirante_automobile.ms.infra.persistence.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
  
}

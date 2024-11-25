package desafio_mirante_automobile.ms.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import desafio_mirante_automobile.ms.domain.model.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
  
}

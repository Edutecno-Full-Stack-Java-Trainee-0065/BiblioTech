package cl.playground.bibliotech.repository;

import cl.playground.bibliotech.model.DetallePrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePrestamoRepository extends JpaRepository<DetallePrestamo, Long> {

    List<DetallePrestamo> findByPrestamoId(Long prestamoId);

}

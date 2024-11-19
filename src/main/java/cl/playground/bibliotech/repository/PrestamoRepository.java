package cl.playground.bibliotech.repository;

import cl.playground.bibliotech.model.Prestamo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    @Query(value = """
            SELECT DISTINCT p.*
            FROM prestamo p
            LEFT JOIN multa m ON m.prestamo_id = p.id
            WHERE (CAST(:fechaInicio AS timestamp) IS NULL OR p.fecha_prestamo >= :fechaInicio)
            AND (CAST(:fechaFin AS timestamp) IS NULL OR p.fecha_prestamo <= :fechaFin)
            AND (
                :estado IS NULL
                OR
                (
                    CASE 
                        WHEN :estado = 'PAGADA' THEN m.estado = 'PAGADA'
                        WHEN :estado = 'PENDIENTE' THEN m.estado = 'PENDIENTE'
                        WHEN :estado = 'SIN_MULTA' THEN m.id IS NULL
                        ELSE true
                    END
                )
            )
            ORDER BY p.fecha_prestamo DESC
            """,
            countQuery = """
            SELECT COUNT(DISTINCT p.id)
            FROM prestamo p
            LEFT JOIN multa m ON m.prestamo_id = p.id
            WHERE (CAST(:fechaInicio AS timestamp) IS NULL OR p.fecha_prestamo >= :fechaInicio)
            AND (CAST(:fechaFin AS timestamp) IS NULL OR p.fecha_prestamo <= :fechaFin)
            AND (
                :estado IS NULL
                OR
                (
                    CASE 
                        WHEN :estado = 'PAGADA' THEN m.estado = 'PAGADA'
                        WHEN :estado = 'PENDIENTE' THEN m.estado = 'PENDIENTE'
                        WHEN :estado = 'SIN_MULTA' THEN m.id IS NULL
                        ELSE true
                    END
                )
            )
            """,
            nativeQuery = true)
    Page<Prestamo> findByFiltros(
            @Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin,
            @Param("estado") String estado,
            Pageable pageable
    );
}

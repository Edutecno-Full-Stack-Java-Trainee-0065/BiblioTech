package cl.playground.bibliotech.mapper;

import cl.playground.bibliotech.dto.DetallePrestamoDTO;
import cl.playground.bibliotech.model.DetallePrestamo;
import org.springframework.stereotype.Component;

@Component
public class DetallePrestamoMapper {

    public static DetallePrestamoDTO toDTO(DetallePrestamo detallePrestamo) {
        if (detallePrestamo == null) {
            return null;
        }

        return DetallePrestamoDTO.builder()
                .libro(detallePrestamo.getLibro().getTitulo())
                .diasPrestamo(detallePrestamo.getDiasPrestamo())
                .precioPorDia(detallePrestamo.getPrecioPorDia())
                .subtotal(detallePrestamo.getSubtotal())
                .build();
    }
}

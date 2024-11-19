package cl.playground.bibliotech.mapper;

import cl.playground.bibliotech.dto.PrestamoDTO;
import cl.playground.bibliotech.model.Prestamo;
import org.springframework.stereotype.Component;

@Component
public class PrestamoMapper {

    public static PrestamoDTO toDTO(Prestamo prestamo) {
        if (prestamo == null) {
            return null;
        }

        return PrestamoDTO.builder()
                .id(prestamo.getId())
                .numeroPrestamo(prestamo.getNumeroPrestamo())
                .fechaPrestamo(prestamo.getFechaPrestamo())
                .total(prestamo.getTotal())
                .usuario(UsuarioMapper.toUsuarioDTO(prestamo.getUsuario()))
                .multa(MultaMapper.toMultaDTO(prestamo.getMulta()))
                .build();
    }
}

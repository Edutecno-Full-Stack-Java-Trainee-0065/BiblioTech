package cl.playground.bibliotech.mapper;

import cl.playground.bibliotech.dto.MultaDTO;
import cl.playground.bibliotech.model.Multa;
import org.springframework.stereotype.Component;

@Component
public class MultaMapper {

    public static MultaDTO toMultaDTO(Multa multa) {
        if (multa == null) return null;

        return MultaDTO.builder()
                .id(multa.getId())
                .numeroMulta(multa.getNumeroMulta())
                .montoTotal(multa.getMontoTotal())
                .estado(multa.getEstado())
                .build();
    }
}

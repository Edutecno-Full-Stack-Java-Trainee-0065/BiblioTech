package cl.playground.bibliotech.dto;

import cl.playground.bibliotech.model.EstadoMulta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoFiltroDTO {
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private EstadoMulta estadoMulta;
}
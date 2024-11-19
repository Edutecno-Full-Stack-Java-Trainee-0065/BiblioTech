package cl.playground.bibliotech.dto;

import cl.playground.bibliotech.model.EstadoMulta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultaDTO {
    private Long id;
    private String numeroMulta;
    private BigDecimal montoTotal;
    private EstadoMulta estado;
}
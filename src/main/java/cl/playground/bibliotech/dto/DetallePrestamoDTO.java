package cl.playground.bibliotech.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetallePrestamoDTO {
    private String libro;
    private Integer diasPrestamo;
    private BigDecimal precioPorDia;
    private BigDecimal subtotal;
}

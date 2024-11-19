package cl.playground.bibliotech.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoDTO {

    private Long id;
    private String numeroPrestamo;
    private LocalDateTime fechaPrestamo;
    private BigDecimal total;
    private UsuarioDTO usuario;
    private MultaDTO multa;

}

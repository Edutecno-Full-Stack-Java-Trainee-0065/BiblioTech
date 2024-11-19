package cl.playground.bibliotech.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "multa")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_multa", nullable = false, length = 50, unique = true)
    private String numeroMulta;

    @Column(name = "fecha_emision")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaEmision;

    @Column(name = "monto_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoTotal;

    @Column(columnDefinition = "boolean default false")
    private Boolean pagado;

    @OneToOne
    @JoinColumn(name = "prestamo_id")
    private Prestamo prestamo;

    @OneToMany(mappedBy = "multa", cascade = CascadeType.ALL)
    private List<PagoMulta> pagos;

}

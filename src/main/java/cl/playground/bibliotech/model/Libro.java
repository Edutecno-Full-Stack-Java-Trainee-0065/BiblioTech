package cl.playground.bibliotech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "libro")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio_alquiler", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioAlquiler;

    @Column(name = "copias_disponibles", nullable = false)
    private Integer copiasDisponibles;

    @Column(name = "fecha_adquisicion")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaAdquisicion;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private GeneroLiterario genero;

    @OneToMany(mappedBy = "libro")
    private List<DetallePrestamo> detallesPrestamo;
}

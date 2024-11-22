package algoritmos;

import cl.playground.bibliotech.model.DetallePrestamo;
import cl.playground.bibliotech.model.Libro;
import cl.playground.bibliotech.model.Prestamo;
import cl.playground.bibliotech.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private static final List<Libro> libros = new ArrayList<>();
    private static final List<Prestamo> prestamos = new ArrayList<>();

    static {
        initLibros();
        initPrestamos();
    }

    private static void initPrestamos() {
        Usuario usuario = Usuario.builder()
                .id(1L)
                .nombre("Juan Pérez")
                .email("juan@email.com")
                .build();

        // Crear préstamo con múltiples libros
        Prestamo prestamo = Prestamo.builder()
                .id(1L)
                .numeroPrestamo("P001-2023")
                .fechaPrestamo(LocalDateTime.of(2023, 11, 15, 10, 0))
                .usuario(usuario)
                .total(new BigDecimal("45.49"))
                .build();

        List<DetallePrestamo> detalles = new ArrayList<>();

        // Agregar 3 libros al préstamo
        detalles.add(DetallePrestamo.builder()
                .id(1L)
                .libro(libros.get(0))
                .diasPrestamo(7)
                .precioPorDia(libros.get(0).getPrecioAlquiler())
                .subtotal(libros.get(0).getPrecioAlquiler().multiply(new BigDecimal("7")))
                .prestamo(prestamo)
                .build());

        detalles.add(DetallePrestamo.builder()
                .id(2L)
                .libro(libros.get(1))
                .diasPrestamo(5)
                .precioPorDia(libros.get(1).getPrecioAlquiler())
                .subtotal(libros.get(1).getPrecioAlquiler().multiply(new BigDecimal("5")))
                .prestamo(prestamo)
                .build());

        detalles.add(DetallePrestamo.builder()
                .id(3L)
                .libro(libros.get(2))
                .diasPrestamo(3)
                .precioPorDia(libros.get(2).getPrecioAlquiler())
                .subtotal(libros.get(2).getPrecioAlquiler().multiply(new BigDecimal("3")))
                .prestamo(prestamo)
                .build());

        prestamo.setDetallesPrestamo(detalles);
        prestamos.add(prestamo);
    }

    private static void initLibros() {
        libros.add(Libro.builder()
                .id(1L)
                .titulo("Cien Años de Soledad")
                .descripcion("Una obra maestra de Gabriel García Márquez.")
                .precioAlquiler(new BigDecimal("12.99"))
                .copiasDisponibles(5)
                .fechaAdquisicion(LocalDateTime.of(2023, 1, 15, 10, 0))
                .editorial(null)
                .genero(null)
                .detallesPrestamo(null)
                .build());

        libros.add(Libro.builder()
                .id(2L)
                .titulo("El Quijote")
                .descripcion("La historia de Don Quijote y Sancho Panza.")
                .precioAlquiler(new BigDecimal("15.50"))
                .copiasDisponibles(3)
                .fechaAdquisicion(LocalDateTime.of(2023, 2, 10, 14, 30))
                .editorial(null)
                .genero(null)
                .detallesPrestamo(null)
                .build());

        libros.add(Libro.builder()
                .id(3L)
                .titulo("1984")
                .descripcion("Una distopía de George Orwell.")
                .precioAlquiler(new BigDecimal("10.00"))
                .copiasDisponibles(8)
                .fechaAdquisicion(LocalDateTime.of(2022, 11, 5, 9, 15))
                .editorial(null)
                .genero(null)
                .detallesPrestamo(null)
                .build());

        libros.add(Libro.builder()
                .id(4L)
                .titulo("El Señor de los Anillos")
                .descripcion("La épica aventura de J.R.R. Tolkien.")
                .precioAlquiler(new BigDecimal("18.75"))
                .copiasDisponibles(7)
                .fechaAdquisicion(LocalDateTime.of(2021, 6, 21, 16, 0))
                .editorial(null)
                .genero(null)
                .detallesPrestamo(null)
                .build());

        libros.add(Libro.builder()
                .id(5L)
                .titulo("Matar a un Ruiseñor")
                .descripcion("Un clásico de Harper Lee.")
                .precioAlquiler(new BigDecimal("9.99"))
                .copiasDisponibles(4)
                .fechaAdquisicion(LocalDateTime.of(2020, 3, 10, 11, 45))
                .editorial(null)
                .genero(null)
                .detallesPrestamo(null)
                .build());

        libros.add(Libro.builder()
                .id(6L)
                .titulo("Orgullo y Prejuicio")
                .descripcion("Una novela de Jane Austen.")
                .precioAlquiler(new BigDecimal("11.50"))
                .copiasDisponibles(6)
                .fechaAdquisicion(LocalDateTime.of(2019, 8, 25, 10, 0))
                .editorial(null)
                .genero(null)
                .detallesPrestamo(null)
                .build());

        libros.add(Libro.builder()
                .id(7L)
                .titulo("La Odisea")
                .descripcion("Un poema épico atribuido a Homero.")
                .precioAlquiler(new BigDecimal("13.00"))
                .copiasDisponibles(2)
                .fechaAdquisicion(LocalDateTime.of(2023, 5, 12, 13, 0))
                .editorial(null)
                .genero(null)
                .detallesPrestamo(null)
                .build());

        libros.add(Libro.builder()
                .id(8L)
                .titulo("Crónica de una Muerte Anunciada")
                .descripcion("Otro clásico de Gabriel García Márquez.")
                .precioAlquiler(new BigDecimal("8.75"))
                .copiasDisponibles(10)
                .fechaAdquisicion(LocalDateTime.of(2022, 12, 1, 8, 30))
                .editorial(null)
                .genero(null)
                .detallesPrestamo(null)
                .build());

        libros.add(Libro.builder()
                .id(9L)
                .titulo("Harry Potter y la Piedra Filosofal")
                .descripcion("El inicio de la saga mágica de J.K. Rowling.")
                .precioAlquiler(new BigDecimal("14.20"))
                .copiasDisponibles(12)
                .fechaAdquisicion(LocalDateTime.of(2020, 7, 18, 19, 0))
                .editorial(null)
                .genero(null)
                .detallesPrestamo(null)
                .build());

        libros.add(Libro.builder()
                .id(10L)
                .titulo("El Principito")
                .descripcion("Un relato para todas las edades de Antoine de Saint-Exupéry.")
                .precioAlquiler(new BigDecimal("7.50"))
                .copiasDisponibles(15)
                .fechaAdquisicion(LocalDateTime.of(2023, 4, 9, 17, 0))
                .editorial(null)
                .genero(null)
                .detallesPrestamo(null)
                .build());
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }
}

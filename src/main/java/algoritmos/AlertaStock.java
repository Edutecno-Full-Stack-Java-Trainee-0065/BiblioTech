package algoritmos;

import cl.playground.bibliotech.model.Libro;
import cl.playground.bibliotech.model.Prestamo;

import java.time.LocalDate;
import java.util.List;


public class AlertaStock {
    public static void verificarStockCritico(List<Libro> libros, Long libroId) {
        Long id = 0L;
        for (Libro libro : libros) {
            if (libro.getId() == libroId) {
                id = libro.getId();
                break;
            }
        }

        Libro libro = libros.get(Math.toIntExact(id));

        if (libro.getCopiasDisponibles() < 5) {
            System.out.println("¡ALERTA! Stock crítico para: " + libro.getTitulo());
            System.out.println("Copias disponibles: " + libro.getCopiasDisponibles());
            System.out.println("Se requiere reposición inmediata");
        }
    }

    public static void calcularPrestamosPeriodo(List<Prestamo> prestamos, Long usuarioId, int mes, int año) {
        LocalDate inicio = LocalDate.of(año, mes, 1);
        LocalDate fin = inicio.plusMonths(1).minusDays(1);

        double total = prestamos.stream()
                .filter(p -> p.getUsuario().getId().equals(usuarioId))
                .filter(p -> {
                    LocalDate fechaPrestamo = p.getFechaPrestamo().toLocalDate();
                    return !fechaPrestamo.isBefore(inicio) && !fechaPrestamo.isAfter(fin);
                })
                .mapToDouble(p -> p.getTotal().doubleValue())
                .sum();

        System.out.println("Total de préstamos para " + mes + "/" + año + ": $" + total);
    }
}

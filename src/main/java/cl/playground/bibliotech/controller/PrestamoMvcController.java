package cl.playground.bibliotech.controller;

import cl.playground.bibliotech.dto.DetallePrestamoDTO;
import cl.playground.bibliotech.dto.PrestamoDTO;
import cl.playground.bibliotech.dto.PrestamoFiltroDTO;
import cl.playground.bibliotech.model.EstadoMulta;
import cl.playground.bibliotech.service.DetallePrestamoService;
import cl.playground.bibliotech.service.PrestamoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/prestamos")
public class PrestamoMvcController {

    private final PrestamoService prestamoService;
    private final DetallePrestamoService detallePrestamoService;

    public PrestamoMvcController(PrestamoService prestamoService, DetallePrestamoService detallePrestamoService) {
        this.prestamoService = prestamoService;
        this.detallePrestamoService = detallePrestamoService;
    }

    @GetMapping
    public String listarPrestamos(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
            @RequestParam(required = false) String estado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        EstadoMulta estadoMulta = null;
        if (estado != null && !estado.isEmpty()) {
            estadoMulta = EstadoMulta.valueOf(estado);
        }

        PrestamoFiltroDTO filtro = PrestamoFiltroDTO.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .estadoMulta(estadoMulta)
                .build();

        // Usando el nombre de la propiedad Java en lugar del nombre de la columna
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "fecha_prestamo"));
        Page<PrestamoDTO> prestamos = prestamoService.buscarPrestamos(filtro, pageable);

        model.addAttribute("prestamos", prestamos);
        model.addAttribute("filtro", filtro);
        model.addAttribute("currentPage", page);
        model.addAttribute("estados", EstadoMulta.values());

        return "prestamos/lista";
    }

    @GetMapping("/{id}")
    public String verDetallesDelPrestamo(@PathVariable("id") Long id, Model model) {
        PrestamoDTO prestamo = prestamoService.obtenerPrestamo(id)
                .orElseThrow(() -> new IllegalArgumentException("Préstamo no encontrado con el id " + id));
        List<DetallePrestamoDTO> detalles = detallePrestamoService.obtenerDetallesPorPrestamoId(id);

        model.addAttribute("prestamo", prestamo);
        model.addAttribute("detalles", detalles);

        return "prestamos/detalle";
    }
}

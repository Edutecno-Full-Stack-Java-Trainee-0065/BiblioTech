package cl.playground.bibliotech.controller;

import cl.playground.bibliotech.dto.PrestamoDTO;
import cl.playground.bibliotech.dto.PrestamoFiltroDTO;
import cl.playground.bibliotech.model.EstadoMulta;
import cl.playground.bibliotech.service.PrestamoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/prestamos")
public class PrestamoMvcController {

    private final PrestamoService prestamoService;

    public PrestamoMvcController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping
    public String listarPrestamos(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
            @RequestParam(required = false) String estado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        PrestamoFiltroDTO filtro = PrestamoFiltroDTO.builder()
                .fechaInicio(fechaInicio)
                .fechaFin(fechaFin)
                .estadoMulta(estado != null ? EstadoMulta.valueOf(estado) : null)
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
}

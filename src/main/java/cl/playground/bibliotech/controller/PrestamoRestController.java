package cl.playground.bibliotech.controller;

import cl.playground.bibliotech.dto.PrestamoDTO;
import cl.playground.bibliotech.dto.PrestamoFiltroDTO;
import cl.playground.bibliotech.model.EstadoMulta;
import cl.playground.bibliotech.service.PrestamoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prestamos")
public class PrestamoRestController {

    private final PrestamoService prestamoService;

    public PrestamoRestController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping("/busquedaPorFiltros")
    public Page<PrestamoDTO> busquedaPorFiltros(
            @RequestParam (required = false) String fechaInicio,
            @RequestParam (required = false) String fechaFin,
            @RequestParam (required = false) EstadoMulta estadoMulta,
            Pageable pageable) {

        LocalDateTime fechaInicioFormated = LocalDateTime.parse(fechaInicio);
        LocalDateTime fechaFinFormated = LocalDateTime.parse(fechaFin);

        PrestamoFiltroDTO prestamoFiltroDTO = PrestamoFiltroDTO.builder()
                .fechaInicio(fechaInicioFormated)
                .fechaFin(fechaFinFormated)
                .estadoMulta(estadoMulta)
                .build();
        return prestamoService.buscarPrestamos(prestamoFiltroDTO, pageable);
    }

    @GetMapping("/{id}/detalle")
    public PrestamoDTO detallePrestamo(@PathVariable Long id) {
        return prestamoService.obtenerPrestamo(id).orElseThrow(()-> new IllegalArgumentException("Id Prestamos no encontrada" + id));
    }
}


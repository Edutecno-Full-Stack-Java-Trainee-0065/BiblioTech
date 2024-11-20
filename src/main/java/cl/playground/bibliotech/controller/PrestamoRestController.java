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
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Page<PrestamoDTO>> busquedaPorFiltros(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
            @RequestParam(required = false) EstadoMulta estadoMulta,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        try {
            PrestamoFiltroDTO filtro = PrestamoFiltroDTO.builder()
                    .fechaInicio(fechaInicio != null ? fechaInicio : LocalDateTime.now().minusYears(1))
                    .fechaFin(fechaFin != null ? fechaFin : LocalDateTime.now())
                    .estadoMulta(estadoMulta)
                    .build();

            Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
            return ResponseEntity.ok(prestamoService.buscarPrestamos(filtro, pageable));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}/detalle")
    public PrestamoDTO detallePrestamo(@PathVariable Long id) {
        return prestamoService.obtenerPrestamo(id).orElseThrow(()-> new IllegalArgumentException("Id Prestamos no encontrada" + id));
    }
}


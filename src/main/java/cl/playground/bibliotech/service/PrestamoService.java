package cl.playground.bibliotech.service;

import cl.playground.bibliotech.dto.PrestamoDTO;
import cl.playground.bibliotech.dto.PrestamoFiltroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface PrestamoService {

    Optional<PrestamoDTO> obtenerPrestamo(Long id);
    Page<PrestamoDTO> buscarPrestamos(PrestamoFiltroDTO filtro, Pageable pageable);

}

package cl.playground.bibliotech.service;

import cl.playground.bibliotech.dto.PrestamoDTO;
import cl.playground.bibliotech.dto.PrestamoFiltroDTO;
import cl.playground.bibliotech.mapper.PrestamoMapper;
import cl.playground.bibliotech.repository.PrestamoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PrestamoDTO> obtenerPrestamo(Long id) {
        return Optional.ofNullable(prestamoRepository.findById(id)
                .map(PrestamoMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Prestamo no encontrado con el id " + id)));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PrestamoDTO> buscarPrestamos(PrestamoFiltroDTO filtro, Pageable pageable) {
        // Validar fechas
        if (filtro.getFechaInicio() != null && filtro.getFechaFin() != null
                && filtro.getFechaInicio().isAfter(filtro.getFechaFin())) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha fin");
        }

        return prestamoRepository.findByFiltros(
                filtro.getFechaInicio(),
                filtro.getFechaFin(),
                String.valueOf(filtro.getEstadoMulta()),
                pageable
        ).map(PrestamoMapper::toDTO);
    }

}

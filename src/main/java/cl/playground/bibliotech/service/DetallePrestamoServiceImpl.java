package cl.playground.bibliotech.service;

import cl.playground.bibliotech.dto.DetallePrestamoDTO;
import cl.playground.bibliotech.mapper.DetallePrestamoMapper;
import cl.playground.bibliotech.repository.DetallePrestamoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetallePrestamoServiceImpl implements DetallePrestamoService {

    private final DetallePrestamoRepository detallePrestamoRepository;

    public DetallePrestamoServiceImpl(DetallePrestamoRepository detallePrestamoRepository) {
        this.detallePrestamoRepository = detallePrestamoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetallePrestamoDTO> obtenerDetallesPorPrestamoId(Long prestamoId) {
        return detallePrestamoRepository.findByPrestamoId(prestamoId)
                .stream()
                .map(DetallePrestamoMapper::toDTO)
                .toList();
    }
}

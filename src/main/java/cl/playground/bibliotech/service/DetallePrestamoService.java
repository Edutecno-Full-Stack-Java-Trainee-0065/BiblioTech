package cl.playground.bibliotech.service;

import cl.playground.bibliotech.dto.DetallePrestamoDTO;

import java.util.List;

public interface DetallePrestamoService {

    List<DetallePrestamoDTO> obtenerDetallesPorPrestamoId(Long prestamoId);

}

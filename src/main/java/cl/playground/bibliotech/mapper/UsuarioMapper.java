package cl.playground.bibliotech.mapper;

import cl.playground.bibliotech.dto.UsuarioDTO;
import cl.playground.bibliotech.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        if (usuario == null) return null;

        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .telefono(usuario.getTelefono())
                .build();
    }


}

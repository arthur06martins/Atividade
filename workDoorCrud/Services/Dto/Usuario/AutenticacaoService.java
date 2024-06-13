package CrudPi.workDoorCrud.Services.Dto.Usuario;




import CrudPi.workDoorCrud.Services.Dto.Usuario.Auth.UsuarioDetalhesDto;
import CrudPi.workDoorCrud.domain.usuario.Usuario;
import CrudPi.workDoorCrud.domain.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional usuarioOpt = usuarioRepository.findByemailUsuario(username);

        if (usuarioOpt.isEmpty()) {

            throw new UsernameNotFoundException(String.format("usuario: %s nao encontrado", username));
        }

        return new UsuarioDetalhesDto((Usuario) usuarioOpt.get());
    }
}



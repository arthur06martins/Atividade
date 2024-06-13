package CrudPi.workDoorCrud.Services;

import CrudPi.workDoorCrud.Services.Dto.Usuario.Auth.UsuarioLoginDto;
import CrudPi.workDoorCrud.Services.Dto.Usuario.Auth.UsuarioTokenDto;
import CrudPi.workDoorCrud.Services.Dto.Usuario.DtoUser.UsuarioCriacaoDto;
import CrudPi.workDoorCrud.Services.Dto.Usuario.DtoUser.UsuarioMapper;
import CrudPi.workDoorCrud.api.configuration.Security.jwt.GerenciadorTokenJwt;
import CrudPi.workDoorCrud.domain.usuario.Usuario;
import CrudPi.workDoorCrud.domain.usuario.repository.UsuarioRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void criar(UsuarioCriacaoDto usuarioCriacaoDto) {
        final Usuario novoUsuario = UsuarioMapper.of(usuarioCriacaoDto);

        String senhaCriptografada = passwordEncoder.encode(novoUsuario.getSenhaUsuario());
        novoUsuario.setSenhaUsuario(senhaCriptografada);

        this.usuarioRepository.save(novoUsuario);
    }

    public UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto) throws Throwable {

        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                usuarioLoginDto.getEmailUsuario(), usuarioLoginDto.getSenhaUsuario());

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Usuario usuarioAutenticado =
                (Usuario) usuarioRepository.findByemailUsuario(usuarioLoginDto.getEmailUsuario())
                        .orElseThrow(
                                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email do usuário não cadastrado", null)
                        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return UsuarioMapper.of(usuarioAutenticado, token);


    }
    public Usuario buscarPorid(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuario não cadastrado"));
    }

}

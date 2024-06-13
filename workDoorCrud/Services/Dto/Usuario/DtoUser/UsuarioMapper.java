package CrudPi.workDoorCrud.Services.Dto.Usuario.DtoUser;


import CrudPi.workDoorCrud.Services.Dto.Usuario.Auth.UsuarioTokenDto;
import CrudPi.workDoorCrud.domain.usuario.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioCriacaoDto usuarioCriacaoDto){

        Usuario usuario = new Usuario();

        String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioCriacaoDto.getSenhaUsuario());
        usuario.setNomeUsuario(usuarioCriacaoDto.getNomeUsuario());
        usuario.setEmailUsuario(usuarioCriacaoDto.getEmailUsuario());
        usuario.setCpf(usuarioCriacaoDto.getCpf());
        usuario.setTelefoneUsuario(usuarioCriacaoDto.getTelefoneUsuario());
        usuario.setSenhaUsuario(encryptedPassword);
        


        return usuario;
    }

    public static UsuarioConsultaDto toDo(Usuario dto){
        if(Objects.isNull(dto)){
            return null;
        }
        UsuarioConsultaDto usuarioConsultaDto = new UsuarioConsultaDto();
        usuarioConsultaDto.setIdUsuario(dto.getIdUsuario());
        usuarioConsultaDto.setNomeUsuario(dto.getNomeUsuario());
        usuarioConsultaDto.setCpf(dto.getCpf());
        usuarioConsultaDto.setEmailUsuario(dto.getEmailUsuario());
        usuarioConsultaDto.setTelefoneUsuario(dto.getTelefoneUsuario());

        return usuarioConsultaDto;
    }
    public static List<UsuarioConsultaDto> toDoList(List<Usuario> usuarios){
        if(Objects.isNull(usuarios)){
            return null;
        }
        List<UsuarioConsultaDto> usuarioCriacaoDtos = new ArrayList<>();
        for(Usuario usuario : usuarios){usuarioCriacaoDtos.add(toDo(usuario));}
        return usuarioCriacaoDtos;
    }

    public static Usuario of(UsuarioCriacaoDto usuarioCriacaoDto) {
        Usuario usuario = new Usuario();

        usuario.setNomeUsuario(usuarioCriacaoDto.getNomeUsuario());
        usuario.setCpf(usuarioCriacaoDto.getCpf());
        usuario.setEmailUsuario(usuarioCriacaoDto.getEmailUsuario());
        usuario.setTelefoneUsuario(usuarioCriacaoDto.getTelefoneUsuario());
        usuario.setSenhaUsuario(usuarioCriacaoDto.getSenhaUsuario());


        return usuario;
    }
    public static UsuarioTokenDto of(Usuario usuario, String token) {
        UsuarioTokenDto usuarioTokenDto = new UsuarioTokenDto();

        usuarioTokenDto.setId(usuario.getIdUsuario());
        usuarioTokenDto.setEmailUsuario(usuario.getEmailUsuario());
        usuarioTokenDto.setNomeUsuario(usuario.getNomeUsuario());
        usuarioTokenDto.setToken(token);

        return usuarioTokenDto;
    }

}

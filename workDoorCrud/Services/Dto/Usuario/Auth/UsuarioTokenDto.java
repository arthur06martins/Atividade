package CrudPi.workDoorCrud.Services.Dto.Usuario.Auth;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioTokenDto {
    private int id;
    private String nomeUsuario;
    private String emailUsuario;
    private String token;


}

package CrudPi.workDoorCrud.Services.Dto.Usuario.DtoUser;

//import CrudPi.workDoorCrud.Enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioConsultaDto {

    private int idUsuario;
    private String nomeUsuario;
    private String cpf;
    private String emailUsuario;
    private String telefoneUsuario;
//    private UserRole role;
}

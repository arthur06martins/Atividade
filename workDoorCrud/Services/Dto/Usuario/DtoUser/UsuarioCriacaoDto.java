package CrudPi.workDoorCrud.Services.Dto.Usuario.DtoUser;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;


@Getter
@Setter
public class UsuarioCriacaoDto{

    @NotBlank
    @Size(min = 3, max = 50)
    private String nomeUsuario;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    private String emailUsuario;

    @NotBlank
    @Size(min = 13, max = 15)
    private String telefoneUsuario;

    @NotBlank
    @Size(min = 8, max =25 )
    private String senhaUsuario;



}

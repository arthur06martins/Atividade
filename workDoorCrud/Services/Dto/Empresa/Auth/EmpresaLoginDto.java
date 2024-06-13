package CrudPi.workDoorCrud.Services.Dto.Empresa.Auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaLoginDto {
    @Schema(description = "E-mail do usuário", example = "john@doe.com")
    private String emailEmpresa;
    @Schema(description = "Senha do usuário", example = "123456")
    private String senhaEmpresa;
}

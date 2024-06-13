package CrudPi.workDoorCrud.Services.Dto.Empresa.Auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaTokenDto {
    private int id;
    private String nomeEmpresa;
    private String emailEmpresa;
    private String token;
}

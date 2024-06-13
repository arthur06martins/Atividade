package CrudPi.workDoorCrud.Services.Dto.Empresa.EmpresaDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaConsultaDto {
    private int id;
    private String nome;
    private String cnpj;
    private String cep;
    private String email;
    private String telefone;

}

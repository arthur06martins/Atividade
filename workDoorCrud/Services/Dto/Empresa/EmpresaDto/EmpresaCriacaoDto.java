package CrudPi.workDoorCrud.Services.Dto.Empresa.EmpresaDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;


@Getter
@Setter
public class EmpresaCriacaoDto {
    @NotNull
    @Size(min = 3, max = 100)
    private String nome;

    @NotNull
    @Size(min = 14, max = 14)
    @CNPJ
    private String cnpj;

    @NotNull
    @Size(min = 9, max = 9)
    private String cep;

    @NotNull
    @Size(min = 15, max = 100)
    private String email;

    @NotNull
    @Size(min = 14, max = 14)
    private String telefone;

    @NotNull
    @Size(min = 12, max = 30)
    private String senha;

}

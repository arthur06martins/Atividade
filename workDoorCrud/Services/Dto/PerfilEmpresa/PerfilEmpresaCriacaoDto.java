package CrudPi.workDoorCrud.Services.Dto.PerfilEmpresa;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilEmpresaCriacaoDto {
    private byte[] fotoPerfilEmpresa;
    private byte[] fotoCapaEmpresa;
    private String corPerfil;
    private int idEmpresa;
}

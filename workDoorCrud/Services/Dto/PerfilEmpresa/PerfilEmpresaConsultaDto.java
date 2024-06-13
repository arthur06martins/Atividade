package CrudPi.workDoorCrud.Services.Dto.PerfilEmpresa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilEmpresaConsultaDto {

    private int idPerfilEmpresa;
    private byte[] fotoPerfilEmpresa;
    private byte[] fotoCapaEmpresa;
    private String corPerfil;
    private int idEmpresa;
}

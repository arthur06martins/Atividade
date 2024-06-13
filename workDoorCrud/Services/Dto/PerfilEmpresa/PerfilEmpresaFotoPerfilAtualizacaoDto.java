package CrudPi.workDoorCrud.Services.Dto.PerfilEmpresa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerfilEmpresaFotoPerfilAtualizacaoDto {
    private byte[] fotoPerfilEmpresa;

    public byte[] getFotoPerfilEmpresa() {
        return fotoPerfilEmpresa;
    }

    public void setFotoPerfilEmpresa(byte[] fotoPerfilEmpresa) {
        this.fotoPerfilEmpresa = fotoPerfilEmpresa;
    }
}
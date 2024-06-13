package CrudPi.workDoorCrud.Services.Dto.PerfilEmpresa;

import CrudPi.workDoorCrud.Services.Dto.Empresa.EmpresaDto.EmpresaConsultaDto;
import CrudPi.workDoorCrud.domain.PerfilEmpresa.PerfilEmpresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PerfilEmpresaMapper {

    public static PerfilEmpresa toEntity(PerfilEmpresaCriacaoDto dto){
        PerfilEmpresa perfil = new PerfilEmpresa();

        perfil.setFotoPerfilEmpresa(dto.getFotoPerfilEmpresa());
        perfil.setFotoCapaEmpresa(dto.getFotoCapaEmpresa());
        perfil.setCorPerfil(dto.getCorPerfil());

        return perfil;
    }

    public static PerfilEmpresaConsultaDto toDto(PerfilEmpresa perfilEmpresa){
        if(Objects.isNull(perfilEmpresa)){
            return null;
        }

        PerfilEmpresaConsultaDto dto = new PerfilEmpresaConsultaDto();
        dto.setIdPerfilEmpresa(perfilEmpresa.getIdPerfilEmpresa());
        dto.setFotoPerfilEmpresa(perfilEmpresa.getFotoPerfilEmpresa());
        dto.setFotoCapaEmpresa(perfilEmpresa.getFotoCapaEmpresa());
        dto.setCorPerfil(perfilEmpresa.getCorPerfil());

        return dto;
    }

    public static PerfilEmpresa of(PerfilEmpresaCriacaoDto dto){
        PerfilEmpresa perfil = new PerfilEmpresa();

        perfil.setFotoPerfilEmpresa(dto.getFotoPerfilEmpresa());
        perfil.setFotoCapaEmpresa(dto.getFotoCapaEmpresa());
        perfil.setCorPerfil(dto.getCorPerfil());

        return perfil;
    }

    public static List<PerfilEmpresaConsultaDto> toDto(List<PerfilEmpresa> perfil){
        List<PerfilEmpresaConsultaDto> perfilEmpresaConsultaDtos = new ArrayList<>();
        for (PerfilEmpresa perfilEmpresa : perfil) {
            perfilEmpresaConsultaDtos.add(toDto(perfilEmpresa));
        }

        return perfilEmpresaConsultaDtos;
    }


}

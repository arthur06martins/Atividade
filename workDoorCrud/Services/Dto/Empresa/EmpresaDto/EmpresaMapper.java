package CrudPi.workDoorCrud.Services.Dto.Empresa.EmpresaDto;

import CrudPi.workDoorCrud.Services.Dto.Empresa.Auth.EmpresaTokenDto;
import CrudPi.workDoorCrud.domain.empresa.Empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmpresaMapper {
    public static Empresa toEntity(EmpresaCriacaoDto dto){
        Empresa empresa = new Empresa();
        empresa.setNome(dto.getNome());
        empresa.setCnpj(dto.getCnpj());
        empresa.setCep(dto.getCep());
        empresa.setEmail(dto.getEmail());
        empresa.setTelefone(dto.getTelefone());
        empresa.setSenha(dto.getSenha());

        return empresa;
    }

    public static EmpresaConsultaDto toDto(Empresa empresa){
       if(Objects.isNull(empresa)){
           return null;
       }
       EmpresaConsultaDto dto = new EmpresaConsultaDto();
       dto.setId(empresa.getId());
       dto.setNome(empresa.getNome());
       dto.setCnpj(empresa.getCnpj());
       dto.setCep(empresa.getCep());
       dto.setEmail(empresa.getEmail());
       dto.setTelefone(empresa.getTelefone());

       return dto;
    }
    public static Empresa of(EmpresaCriacaoDto dto){
        Empresa empresa = new Empresa();

        empresa.setEmail(dto.getEmail());
        empresa.setCnpj(dto.getCnpj());
        empresa.setCep(dto.getCep());
        empresa.setNome(dto.getNome());
        empresa.setTelefone(dto.getTelefone());
        return empresa;
    }

    public static EmpresaTokenDto of(Empresa empresa, String token) {
        EmpresaTokenDto empresaToken = new EmpresaTokenDto();

        empresaToken.setId(empresa.getId());
        empresaToken.setEmailEmpresa(empresa.getEmail());
        empresaToken.setNomeEmpresa(empresa.getNome());
        empresaToken.setToken(token);

        return empresaToken;
    }


    public static List<EmpresaConsultaDto> toDto(List<Empresa> empresas){
        List<EmpresaConsultaDto> empresasDto = new ArrayList<>();
        for(Empresa emp : empresas){
            empresasDto.add(toDto(emp));
        }

        return empresasDto;
    }

    public static Empresa toUpdate(Empresa empresa, EmpresaAtualizacaoDto dto){
        if(dto.getEmail() != null){
            empresa.setEmail(dto.getEmail());
        }

        if(dto.getTelefone() != null){
            empresa.setTelefone(dto.getTelefone());
        }

        return empresa;
    }
}

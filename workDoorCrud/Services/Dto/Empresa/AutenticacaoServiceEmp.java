package CrudPi.workDoorCrud.Services.Dto.Empresa;


import CrudPi.workDoorCrud.Services.Dto.Empresa.Auth.EmpresaDetalhesDto;
import CrudPi.workDoorCrud.domain.empresa.Empresa;
import CrudPi.workDoorCrud.domain.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AutenticacaoServiceEmp implements UserDetailsService {
    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public UserDetails loadUserByUsername(String emailEmpresa) throws UsernameNotFoundException {
        Optional empresaOpt = empresaRepository.findByEmail(emailEmpresa);

        if(empresaOpt.isEmpty()){
            throw new UsernameNotFoundException(String.format("empresa %s não encontrada",emailEmpresa));
        }
        return new EmpresaDetalhesDto((Empresa)empresaOpt.get());
    }
}

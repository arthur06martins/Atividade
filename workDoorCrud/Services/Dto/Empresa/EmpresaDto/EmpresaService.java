package CrudPi.workDoorCrud.Services.Dto.Empresa.EmpresaDto;

import CrudPi.workDoorCrud.Services.Dto.Empresa.Auth.EmpresaLoginDto;
import CrudPi.workDoorCrud.Services.Dto.Empresa.Auth.EmpresaTokenDto;
import CrudPi.workDoorCrud.api.configuration.Security.jwt.GerenciadorTokenJwt;
import CrudPi.workDoorCrud.domain.empresa.Empresa;
import CrudPi.workDoorCrud.domain.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Autowired
    private AuthenticationManager authenticationManager;


    public ResponseEntity criar(EmpresaCriacaoDto  empresaCriacaoDto){
        Optional empresaConsulta = empresaRepository.findByEmail(empresaCriacaoDto.getEmail());
        if(empresaConsulta.isPresent()){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        final Empresa empresa = EmpresaMapper.of(empresaCriacaoDto);

        String senhaCriptogradada = passwordEncoder.encode(empresa.getSenha());
        empresa.setSenha(senhaCriptogradada);

        this.empresaRepository.save(empresa);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public EmpresaTokenDto autenticar(EmpresaLoginDto empresaLoginDto)throws Throwable{
        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
               empresaLoginDto.getEmailEmpresa(), empresaLoginDto.getSenhaEmpresa());
        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Empresa empresaAutentication =
                (Empresa) empresaRepository.findByEmail(empresaLoginDto.getEmailEmpresa()
                        ).orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"email do usuario não encontrado",null)
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return EmpresaMapper.of(empresaAutentication, token);
    }
}

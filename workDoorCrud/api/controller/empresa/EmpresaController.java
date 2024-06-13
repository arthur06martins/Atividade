package CrudPi.workDoorCrud.api.controller.empresa;

import CrudPi.workDoorCrud.GeracaoToken;
import CrudPi.workDoorCrud.Services.Dto.Empresa.Auth.EmpresaLoginDto;
import CrudPi.workDoorCrud.Services.Dto.Empresa.Auth.EmpresaTokenDto;
import CrudPi.workDoorCrud.Services.Dto.Empresa.EmpresaDto.*;
import CrudPi.workDoorCrud.Services.Dto.PerfilEmpresa.PerfilEmpresaCorAtualizacaoDto;
import CrudPi.workDoorCrud.Services.Dto.PerfilEmpresa.PerfilEmpresaFotoCapaAtualizacaoDto;
import CrudPi.workDoorCrud.Services.Dto.PerfilEmpresa.PerfilEmpresaFotoPerfilAtualizacaoDto;
import CrudPi.workDoorCrud.Services.Dto.Usuario.Auth.UsuarioLoginDto;
import CrudPi.workDoorCrud.Services.Dto.Usuario.Auth.UsuarioTokenDto;
import CrudPi.workDoorCrud.Services.Dto.Usuario.DtoUser.UsuarioCriacaoDto;
import CrudPi.workDoorCrud.domain.CadServico.CadastrarServico;
import CrudPi.workDoorCrud.domain.CadServico.repository.CadServicoRepository;
import CrudPi.workDoorCrud.domain.PerfilEmpresa.PerfilEmpresa;
import CrudPi.workDoorCrud.domain.PerfilEmpresa.Repository.PerfilEmpresaRepository;
import CrudPi.workDoorCrud.domain.empresa.Empresa;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import CrudPi.workDoorCrud.domain.empresa.repository.EmpresaRepository;
import CrudPi.workDoorCrud.Build.EnderecoApiExternaDto;
import CrudPi.workDoorCrud.Build.EnderecoDto;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UncheckedIOException;
import java.util.List;

import java.util.Map;
import java.util.Optional;



@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private CadServicoRepository cadServicoRepository;

    @Autowired
    private GeracaoToken geracaoToken;

    @Autowired
    private PerfilEmpresaRepository perfilEmpresaRepository;

    @Autowired
    private EmpresaRepository repository;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Empresa>> listar(){
        List<Empresa> empresas = repository.findAll();
        return ResponseEntity.status(200).body(empresas);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<EmpresaConsultaDto> create(@RequestBody @Valid EmpresaCriacaoDto empresa){
        Empresa empresaConvertida = EmpresaMapper.toEntity(empresa);
        Empresa empresaCriada = repository.save(empresaConvertida);
        EmpresaConsultaDto empresaConsulta = EmpresaMapper.toDto(empresaCriada);

        return ResponseEntity.status(201).body(empresaConsulta);
    }

    @PutMapping("/atualizarNome/{id}")
    public ResponseEntity<Empresa> atualizarNome(@PathVariable int id, @RequestBody String novoNome) {
        Optional<Empresa> optionalEmpresa = repository.findById(id);
        if(optionalEmpresa.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        Empresa empresa = optionalEmpresa.get();
        empresa.setNome(novoNome);
        Empresa empresaAtualizada = repository.save(empresa);
        return ResponseEntity.status(200).body(empresaAtualizada);
    }

    @PutMapping("/atualizarEmail/{id}")
    public ResponseEntity<Empresa> atualizarEmail(@PathVariable int id, @RequestBody String novoEmail) {
        Optional<Empresa> optionalEmpresa = repository.findById(id);
        if(optionalEmpresa.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        Empresa empresa = optionalEmpresa.get();
        empresa.setEmail(novoEmail);
        Empresa empresaAtualizada = repository.save(empresa);
        return ResponseEntity.status(200).body(empresaAtualizada);
    }
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        repository.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("filtrar/{id}")
    public ResponseEntity<Optional> findById(@PathVariable int id){
        Optional<Empresa> empresaProcurada = repository.findById(id);
        if(empresaProcurada.isEmpty()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(empresaProcurada);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String senha = credentials.get("senha");

        Optional empresa = repository.findByEmail(email);
        if (empresa == null) {
            return ResponseEntity.status(404).body("Empresa não encontrada");
        }
        String token = geracaoToken.generateToken(email);

        return ResponseEntity.status(200).body(token);
    }
    @PostMapping("/cadastrarServico")
    public ResponseEntity<CadastrarServico> cadastrarServico(@RequestBody CadastrarServico cadastrarServico){
        CadastrarServico servico = cadServicoRepository.save(cadastrarServico);
        return ResponseEntity.status(201).body(servico);
    }

    @GetMapping("/listarServicos")
    public ResponseEntity<List<CadastrarServico>> listarServicos(){
        List<CadastrarServico> servicos = cadServicoRepository.findAll();
        for (CadastrarServico servico : servicos) {
            System.out.println(servico);
        }

        return ResponseEntity.status(200).body(servicos);
    }
    @DeleteMapping("/deletarServico/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable int id){
        Optional<CadastrarServico> servico = cadServicoRepository.findById(id);
        if(servico.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        cadServicoRepository.deleteById(id);
        return ResponseEntity.status(204).build();
    }
    @PutMapping("/atualizarFotoPerfil/{id}")
    public ResponseEntity<PerfilEmpresa> atualizarFotoPerfil(@PathVariable int id, @RequestBody PerfilEmpresaFotoPerfilAtualizacaoDto perfilEmpresaFotoPerfilAtualizacaoDto) {
        Optional<PerfilEmpresa> optionalPerfilEmpresa = perfilEmpresaRepository.findById(id);
        if(optionalPerfilEmpresa.isEmpty()){
            return ResponseEntity.status(404).build();
        }
        PerfilEmpresa perfilEmpresa = optionalPerfilEmpresa.get();
        PerfilEmpresa perfilEmpresaAtualizado = perfilEmpresaRepository.save(perfilEmpresa);
        return ResponseEntity.status(200).body(perfilEmpresaAtualizado);
    }

    @GetMapping("/exportarEmpresas")
    public ResponseEntity<String> exportarCSV() {
        List<Empresa> empresas = repository.findAll();

        StringBuilder arq = new StringBuilder();
        arq.append("id,nome,cnpj,cep,email,telefone\n");

        for (Empresa empresa : empresas) {
            arq.append(empresa.getId());
            arq.append(",");
            arq.append(empresa.getNome());
            arq.append(",");
            arq.append(empresa.getCnpj());
            arq.append(",");
            arq.append(empresa.getCep());
            arq.append(",");
            arq.append(empresa.getEmail());
            arq.append(",");
            arq.append(empresa.getTelefone());
            arq.append("\n");
        }
        String dadosCsv = arq.toString();

        HttpHeaders head = new HttpHeaders();
        head.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=empresas.csv");

        return ResponseEntity.status(200).headers(head).contentType(MediaType.parseMediaType("text/csv")).body(dadosCsv);
    }

    @GetMapping("/exportarServicos")
    public ResponseEntity<String> exportarServicosCSV() {
        List<CadastrarServico> servicos = cadServicoRepository.findAll();

        StringBuilder arq = new StringBuilder();
        arq.append("id,nomeServico,descricaoServico,precoServico\n");

        for (CadastrarServico servico : servicos) {
            arq.append(servico.getIdCadServico());
            arq.append(",");
            arq.append(servico.getNomeServico());
            arq.append(",");
            arq.append(servico.getDescricaoServico());
            arq.append(",");
            arq.append(servico.getValorServico());
            arq.append("\n");
        }
        String dadosCsv = arq.toString();

        HttpHeaders head = new HttpHeaders();
        head.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=servicos.csv");

        return ResponseEntity.status(200).headers(head).contentType(MediaType.parseMediaType("text/csv")).body(dadosCsv);
    }
}

//package CrudPi.workDoorCrud.api.controller.usuario;
//
//import CrudPi.workDoorCrud.Build.EnderecoApiExternaDto;
//import CrudPi.workDoorCrud.Build.EnderecoDto;
//import CrudPi.workDoorCrud.Services.Dto.Usuario.Auth.UsuarioLoginDto;
//import CrudPi.workDoorCrud.Services.Dto.Usuario.Auth.UsuarioTokenDto;
//import CrudPi.workDoorCrud.Services.Dto.Usuario.DtoUser.UsuarioConsultaDto;
//import CrudPi.workDoorCrud.Services.Dto.Usuario.DtoUser.UsuarioCriacaoDto;
//import CrudPi.workDoorCrud.Services.Dto.Usuario.DtoUser.UsuarioMapper;
//import CrudPi.workDoorCrud.Services.UsuarioService;
//import CrudPi.workDoorCrud.domain.usuario.Usuario;
//import CrudPi.workDoorCrud.domain.usuario.repository.UsuarioRepository;
//
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/usuarios")
//public class UsuarioController {
//
//    @Autowired
//    private UsuarioRepository repository;
//
//    @Autowired
//    private UsuarioService usuarioService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping("/login")
//    public ResponseEntity<UsuarioTokenDto> login(@RequestBody @Valid UsuarioLoginDto data) throws Throwable {
//        UsuarioTokenDto usuarioTokenDto = this.usuarioService.autenticar(data);
//        return ResponseEntity.status(200).body(usuarioTokenDto);
//    }
//
//    @PostMapping("/cadastrar")
//    @SecurityRequirement(name = "Bearer")
//    public ResponseEntity register(@RequestBody @Valid UsuarioCriacaoDto data) {
//        this.usuarioService.criar(data);
//        return ResponseEntity.status(201).body(data);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<UsuarioConsultaDto>> listar(){
//        List<Usuario> usuarios = repository.findAll();
//        List<UsuarioConsultaDto> dto = UsuarioMapper.toDoList(usuarios);
//        return ResponseEntity.status(200).body(dto);
//    }
//
//    @GetMapping("/buscarPorId/{id}")
//    public ResponseEntity<UsuarioConsultaDto> buscarId(@PathVariable int id){
//        Usuario user = repository.findById(id).get();
//        return ResponseEntity.status(200).body(UsuarioMapper.toDo(user));
//    }
//
//
//    @GetMapping("/endereco/{cep}")
//    @SecurityRequirement(name = "Bearer")
//    public ResponseEntity<EnderecoDto> buscarEndereco(@RequestParam String cep) {
//
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//
//        String raw = restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json", String.class);
//
//        EnderecoApiExternaDto endereco = restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json", EnderecoApiExternaDto.class);
//
//        if (endereco == null) {
//            return ResponseEntity.noContent().build();
//        }
//
//        EnderecoDto resposta = new EnderecoDto();
//        resposta.setBairro(endereco.getBairro());
//        resposta.setCep(endereco.getCep());
//        resposta.setCidade(endereco.getCidade());
//        resposta.setEstado(endereco.getEstado());
//        resposta.setRua(endereco.getRua());
//
//        return ResponseEntity.ok(resposta);
//    }
//
//    @GetMapping("/exportar")
//    @SecurityRequirement(name = "Bearer")
//    public ResponseEntity<String> exportarCSV() {
//        List<Usuario> usuarios = repository.findAll();
//
//        StringBuilder arq = new StringBuilder();
//        arq.append("id,nome,email,telefone\n");
//
//        for (Usuario usuario : usuarios) {
//            arq.append(usuario.getIdUsuario());
//            arq.append(",");
//            arq.append(usuario.getNomeUsuario());
//            arq.append(",");
//            arq.append(usuario.getEmailUsuario());
//            arq.append(",");
//            arq.append(usuario.getTelefoneUsuario());
//            arq.append("\n");
//        }
//        String dadosCsv = arq.toString();
//
//        HttpHeaders head = new HttpHeaders();
//        head.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=usuarios.csv");
//
//        return ResponseEntity.status(200).headers(head).contentType(MediaType.parseMediaType("text/csv")).body(dadosCsv);
//    }
//
////    @PutMapping("/atualizarEmail/{id}")
////    @SecurityRequirement(name = "Bearer")
////    public ResponseEntity<UsuarioConsultaDto> atualizarEmail(@PathVariable int id, @RequestBody String novoEmail) {
////        Usuario user = repository.findById(id).get();
////        if (user == null) {
////            return ResponseEntity.status(404).build();
////        }
////        user.setEmailUsuario(novoEmail);
////        repository.save(user);
////        return ResponseEntity.status(200).body(UsuarioMapper.toDo(user));
////    }
////
////    @PutMapping("/atualizarNome/{id}")
////    @SecurityRequirement(name = "Bearer")
////    public ResponseEntity<UsuarioConsultaDto> atualizarNome(@PathVariable int id, @RequestBody String novoNome) {
////        Usuario user = repository.findById(id).get();
////        if (user == null) {
////            return ResponseEntity.status(404).build();
////        }
////        user.setNomeUsuario(novoNome);
////        repository.save(user);
////        return ResponseEntity.status(200).body(UsuarioMapper.toDo(user));
////    }
//
//}

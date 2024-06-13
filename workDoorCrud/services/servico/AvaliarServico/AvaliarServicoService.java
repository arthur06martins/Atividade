package CrudPi.workDoorCrud.services.servico.AvaliarServico;

import CrudPi.workDoorCrud.Services.UsuarioService;
import CrudPi.workDoorCrud.domain.servico.avaliar.AvaliarServico;
import CrudPi.workDoorCrud.domain.servico.avaliar.repository.AvaliarServicoRepository;
import CrudPi.workDoorCrud.services.servico.AvaliarServico.dto.AvaliarServicoConsultaDto;
import CrudPi.workDoorCrud.services.servico.AvaliarServico.dto.AvaliarServicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvaliarServicoService {

    @Autowired
    private AvaliarServicoRepository avaliarServicoRepository;

    @Autowired
    private AvaliarServicoMapper avaliarServicoMapper;

    @Autowired
    private UsuarioService usuarioService;

    public AvaliarServicoConsultaDto save(AvaliarServico dto) {
        AvaliarServico avaliarServico = avaliarServicoMapper.toEntity(dto);
        avaliarServico = avaliarServicoRepository.save(avaliarServico);
        return avaliarServicoMapper.toDto(avaliarServico);
    }

    public AvaliarServicoConsultaDto findById(Integer id) {
        Optional<AvaliarServico> optional = avaliarServicoRepository.findById(id);
        return optional.map(avaliarServicoMapper::toDto).orElse(null);
    }

    public List<AvaliarServicoConsultaDto> findAll() {
        List<AvaliarServico> lista = avaliarServicoRepository.findAll();
        return lista.stream().map(avaliarServicoMapper::toDto).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        avaliarServicoRepository.deleteById(id);
    }

    public AvaliarServicoConsultaDto update(AvaliarServico dto) {
        AvaliarServico avaliarServico = avaliarServicoMapper.toEntity(dto);
        avaliarServico = avaliarServicoRepository.save(avaliarServico);
        return avaliarServicoMapper.toDto(avaliarServico);
    }
}

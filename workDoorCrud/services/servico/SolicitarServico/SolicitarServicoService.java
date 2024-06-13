package CrudPi.workDoorCrud.services.servico.SolicitarServico;

import CrudPi.workDoorCrud.domain.servico.solicitar.SolicitarServico;

import CrudPi.workDoorCrud.services.servico.SolicitarServico.dto.SolicitarServicoMapper;
import CrudPi.workDoorCrud.domain.servico.solicitar.repository.SolicitarServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitarServicoService {

    @Autowired
    private SolicitarServicoRepository solicitarServicoRepository;

    @Autowired
    private SolicitarServicoMapper solicitarServicoMapper;

    public SolicitarServico save(SolicitarServico dto) {
        SolicitarServico solicitarServico = solicitarServicoMapper.toEntity(dto);
        solicitarServico = solicitarServicoRepository.save(solicitarServico);
        return solicitarServicoMapper.toDto(solicitarServico);
    }

    public SolicitarServico findById(Integer id) {
        Optional<SolicitarServico> solicitarServico = solicitarServicoRepository.findById(id);
        return solicitarServico.map(solicitarServicoMapper::toDto).orElse(null);
    }

    public List<SolicitarServico> findAll() {
        List<SolicitarServico> solicitarServicos = solicitarServicoRepository.findAll();
        return solicitarServicoMapper.toDtoList(solicitarServicos);
    }

    public void deleteById(Integer id) {
        solicitarServicoRepository.deleteById(id);
    }

    public SolicitarServico update(SolicitarServico dto) {
        SolicitarServico solicitarServico = solicitarServicoMapper.toEntity(dto);
        solicitarServico = solicitarServicoRepository.save(solicitarServico);
        return solicitarServicoMapper.toDto(solicitarServico);
    }
}

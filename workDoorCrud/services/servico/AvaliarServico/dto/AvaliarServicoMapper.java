package CrudPi.workDoorCrud.services.servico.AvaliarServico.dto;

import CrudPi.workDoorCrud.domain.servico.avaliar.AvaliarServico;
import CrudPi.workDoorCrud.domain.servico.solicitar.SolicitarServico;
import CrudPi.workDoorCrud.domain.servico.solicitar.repository.SolicitarServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AvaliarServicoMapper {

    @Autowired
    private SolicitarServicoRepository solicitarServicoRepository;

    public AvaliarServico toEntity(AvaliarServico dto) {
        if (dto == null) {
            return null;
        }

        AvaliarServico avaliarServico = new AvaliarServico();

        // Buscar a entidade SolicitarServico pelo ID
        Optional<SolicitarServico> optionalSolicitarServico = solicitarServicoRepository.findById(dto.getSolicitarServico().getId());

        if (optionalSolicitarServico.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SolicitarServico not found with id " + dto.getSolicitarServico().getId());
        }

        avaliarServico.setSolicitarServico(optionalSolicitarServico.get());
        avaliarServico.setNota(dto.getNota());
        avaliarServico.setComentario(dto.getComentario());

        return avaliarServico;
    }

    public AvaliarServicoConsultaDto toDto(AvaliarServico avaliarServico) {
        if (avaliarServico == null) {
            return null;
        }

        AvaliarServicoConsultaDto dto = new AvaliarServicoConsultaDto();
        dto.setId(avaliarServico.getId());
        dto.setNota(avaliarServico.getNota());
        dto.setComentario(avaliarServico.getComentario());

        if (avaliarServico.getSolicitarServico() != null) {
            dto.setSolicitarServico(avaliarServico.getSolicitarServico());
        }

        return dto;
    }

    public List<AvaliarServicoConsultaDto> toDtoList(List<AvaliarServico> avaliarServicos) {
        List<AvaliarServicoConsultaDto> dtos = new ArrayList<>();
        for (AvaliarServico avaliarServico : avaliarServicos) {
            dtos.add(toDto(avaliarServico));
        }
        return dtos;
    }
}

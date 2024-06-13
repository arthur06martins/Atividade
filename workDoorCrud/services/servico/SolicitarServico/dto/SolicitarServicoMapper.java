package CrudPi.workDoorCrud.services.servico.SolicitarServico.dto;

import CrudPi.workDoorCrud.Services.UsuarioService;
import CrudPi.workDoorCrud.domain.CadServico.CadastrarServico;
import CrudPi.workDoorCrud.domain.CadServico.repository.CadServicoRepository;
import CrudPi.workDoorCrud.domain.servico.solicitar.SolicitarServico;
import CrudPi.workDoorCrud.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SolicitarServicoMapper {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CadServicoRepository cadServicoRepository;

    public SolicitarServico toEntity(SolicitarServico dto) {
        if (dto == null) {
            return null;
        }
        SolicitarServico solicitarServico = new SolicitarServico();
        solicitarServico.setId(dto.getId());
        solicitarServico.setDataHoraContratacao(dto.getDataHoraContratacao());
        solicitarServico.setObservacao(dto.getObservacao());
        solicitarServico.setStatusSolicitacaoServico(dto.getStatusSolicitacaoServico());

        Usuario usuario = usuarioService.buscarPorid(dto.getUsuario().getIdUsuario());
        solicitarServico.setUsuario(usuario);

        CadastrarServico cadastrarServico = cadServicoRepository.findById(dto.getId()).orElse(null);
        solicitarServico.setServicoCadastrado(cadastrarServico);

        return solicitarServico;
    }

    public SolicitarServico toDto(SolicitarServico entity) {
        if (entity == null) {
            return null;
        }
        SolicitarServico dto = new SolicitarServico();
        dto.setId(entity.getId());
        dto.setDataHoraContratacao(entity.getDataHoraContratacao());
        dto.setObservacao(entity.getObservacao());
        dto.setStatusSolicitacaoServico(entity.getStatusSolicitacaoServico());

        dto.setUsuario(entity.getUsuario());
        dto.setServicoCadastrado(entity.getServicoCadastrado());

        return dto;
    }

    public List<SolicitarServico> toDtoList(List<SolicitarServico> entityList) {
        if (entityList == null) {
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<SolicitarServico> toEntityList(List<SolicitarServico> dtoList) {
        if (dtoList == null) {
            return null;
        }
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}

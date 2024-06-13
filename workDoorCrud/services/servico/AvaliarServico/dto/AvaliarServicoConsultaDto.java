package CrudPi.workDoorCrud.services.servico.AvaliarServico.dto;

import CrudPi.workDoorCrud.domain.servico.solicitar.SolicitarServico;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AvaliarServicoConsultaDto {

    private Integer id;

    private SolicitarServico solicitarServico;
    private Integer nota;
    private String comentario;
}

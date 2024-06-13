package CrudPi.workDoorCrud.services.servico.SolicitarServico.dto;

import CrudPi.workDoorCrud.domain.CadServico.CadastrarServico;
import CrudPi.workDoorCrud.domain.servico.solicitar.StatusSolicitacaoServico;
import CrudPi.workDoorCrud.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;

public class SolicitarServicoConsultaDto {

    private Integer id;
    private LocalDate dataHoraContratacao;
    private String observacao;
    private StatusSolicitacaoServico statusSolicitacaoServico;
    private Usuario usuario;
    private CadastrarServico servicoCadastrado;

}

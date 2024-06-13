package CrudPi.workDoorCrud.services.servico.SolicitarServico.dto;

import CrudPi.workDoorCrud.domain.CadServico.CadastrarServico;
import CrudPi.workDoorCrud.domain.servico.solicitar.StatusSolicitacaoServico;
import CrudPi.workDoorCrud.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class SolicitarServicoCriacaoDto {

    @Positive
    private LocalDate dataHoraContratacao;

    @Size(min = 0, max = 400)
    private String observacao;

    @NotNull
    private StatusSolicitacaoServico statusSolicitacaoServico;

    @NotNull
    private Usuario usuario;

    @NotNull
    private CadastrarServico servicoCadastrado;

}

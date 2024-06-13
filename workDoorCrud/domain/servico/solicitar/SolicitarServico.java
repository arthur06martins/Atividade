package CrudPi.workDoorCrud.domain.servico.solicitar;

import CrudPi.workDoorCrud.domain.CadServico.CadastrarServico;
import CrudPi.workDoorCrud.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//posttagemEmpreSA
//SOLICITARsERVICO
//avaliar
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitarServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataHoraContratacao;

    private String observacao;

    private StatusSolicitacaoServico statusSolicitacaoServico;

    @ManyToOne
    @JoinColumn (name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn (name = "id_cadastrarServico", nullable = false)
    private CadastrarServico servicoCadastrado;




}

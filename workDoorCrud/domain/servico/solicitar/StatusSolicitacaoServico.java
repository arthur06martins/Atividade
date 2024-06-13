package CrudPi.workDoorCrud.domain.servico.solicitar;


import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusSolicitacaoServico {

    PENDENTE("pendente"),

    RECUSADO("recusado"),

    CONCLUIDO("concluido");

    @Enumerated
    private String statusServico;



}

package CrudPi.workDoorCrud.services.servico.AvaliarServico.dto;

import CrudPi.workDoorCrud.domain.servico.solicitar.SolicitarServico;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliarServicoCriacaoDto {

    @NotNull
    private SolicitarServico solicitarServico;

    @Positive
    private Integer nota;

    @Max(500)
    private String comentario;

    public void setNota(Integer nota) {
        if(nota >= 0 || nota <= 5) {
            this.nota=nota;
        }
        System.out.println("O valor deve ser entre 0 e 5");

    }
}

package CrudPi.workDoorCrud.domain.servico.avaliar;


import CrudPi.workDoorCrud.domain.servico.solicitar.SolicitarServico;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliarServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private SolicitarServico solicitarServico;

    @Size(min = 1,max = 5)
    private Integer nota;

    private String comentario;


}

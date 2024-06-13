package CrudPi.workDoorCrud.domain.CadServico;

import CrudPi.workDoorCrud.domain.empresa.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.net.ssl.SSLSession;

@Getter
@Setter
@Entity
public class CadastrarServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCadServico;

    private String nomeServico;

    @JsonIgnore
    @Column(length = 100 * 1024 * 1024)
    private byte[] fotoServicoCadastrado;

    private String descricaoServico;

    private Double valorServico;

    @OneToOne
    private Empresa empresa;
}

package CrudPi.workDoorCrud.domain.PerfilEmpresa;

import CrudPi.workDoorCrud.domain.empresa.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class PerfilEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfilEmpresa;

    @JsonIgnore
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] fotoPerfilEmpresa;

    @JsonIgnore
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] fotoCapaEmpresa;

    private String corPerfil;

    @OneToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

}
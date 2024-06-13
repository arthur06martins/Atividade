package CrudPi.workDoorCrud.domain.usuario;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String nomeUsuario;
    private String cpf;
    private String emailUsuario;
    private String telefoneUsuario;
    private String senhaUsuario;

}


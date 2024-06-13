package CrudPi.workDoorCrud.domain.empresa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Empresa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cnpj;
    private String cep;
    private String email;
    private String telefone;
    private String senha;


    @Override
    public String toString() {
        return String.format( """
                Id : %d
                Nome : %s 
                CNPJ : %s
                CEP : %s
                Email : %s
                Telefone : %s
                """, id, nome, cnpj, cep,email, telefone);
    }
}

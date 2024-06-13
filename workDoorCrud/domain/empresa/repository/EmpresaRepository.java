package CrudPi.workDoorCrud.domain.empresa.repository;

import CrudPi.workDoorCrud.domain.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    Optional<Empresa> findByCnpj(String cnpj);
    Optional findByEmail(String email);
    List<Empresa> findByNome(String nome);
    Optional<Empresa> findById(Integer id);


}

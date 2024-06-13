package CrudPi.workDoorCrud.domain.PerfilEmpresa.Repository;

import CrudPi.workDoorCrud.domain.PerfilEmpresa.PerfilEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilEmpresaRepository extends JpaRepository<PerfilEmpresa,Integer>{

    // Procurar pelo id :D:D:D:D:D:D:D:D:D:D
    Optional<PerfilEmpresa> findById(Integer integer);
}

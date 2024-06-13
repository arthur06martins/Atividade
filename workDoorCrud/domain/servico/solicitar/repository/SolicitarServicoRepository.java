package CrudPi.workDoorCrud.domain.servico.solicitar.repository;

import CrudPi.workDoorCrud.domain.servico.solicitar.SolicitarServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SolicitarServicoRepository extends JpaRepository<SolicitarServico, Integer>{

    Optional<SolicitarServico> findById(Integer id);
}

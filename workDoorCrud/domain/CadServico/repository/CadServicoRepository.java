package CrudPi.workDoorCrud.domain.CadServico.repository;

import CrudPi.workDoorCrud.domain.CadServico.CadastrarServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadServicoRepository extends JpaRepository<CadastrarServico, Integer> {
}

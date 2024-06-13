package CrudPi.workDoorCrud.api.controller.servico.solicitar;

import CrudPi.workDoorCrud.domain.servico.solicitar.SolicitarServico;
import CrudPi.workDoorCrud.services.servico.SolicitarServico.SolicitarServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitarservicos")
public class SolicitarServicoController {

    @Autowired
    private SolicitarServicoService solicitarServicoService;

    @PostMapping
    public ResponseEntity<SolicitarServico> create(@RequestBody SolicitarServico dto) {
        SolicitarServico createdDto = solicitarServicoService.save(dto);
        return ResponseEntity.ok(createdDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitarServico> getById(@PathVariable Integer id) {
        SolicitarServico dto = solicitarServicoService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<SolicitarServico>> getAll() {
        List<SolicitarServico> dtos = solicitarServicoService.findAll();
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitarServico> update(@PathVariable Integer id, @RequestBody SolicitarServico dto) {
        if (!id.equals(dto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        SolicitarServico updatedDto = solicitarServicoService.update(dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        solicitarServicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

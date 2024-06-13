package CrudPi.workDoorCrud.api.controller.servico.solicitar;

import CrudPi.workDoorCrud.domain.servico.avaliar.AvaliarServico;
import CrudPi.workDoorCrud.services.servico.AvaliarServico.AvaliarServicoService;
import CrudPi.workDoorCrud.services.servico.AvaliarServico.dto.AvaliarServicoConsultaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliar-servico")
public class AvaliarServicoController {

    @Autowired
    public AvaliarServicoService avaliarServicoService;

    @PostMapping
    public ResponseEntity<AvaliarServicoConsultaDto> create(@RequestBody AvaliarServico dto) {
        AvaliarServicoConsultaDto createdDto = avaliarServicoService.save(dto);
        return ResponseEntity.ok(createdDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliarServico> getById(@PathVariable Integer id) {
        AvaliarServicoConsultaDto dto = avaliarServicoService.findById(id);
        return dto != null ? (ResponseEntity<AvaliarServico>) ResponseEntity.ok() : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AvaliarServicoConsultaDto>> getAll() {
        List<AvaliarServicoConsultaDto> dtos = avaliarServicoService.findAll();
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliarServicoConsultaDto> update(@PathVariable Integer id, @RequestBody AvaliarServico dto) {
        if (!id.equals(dto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        AvaliarServicoConsultaDto updatedDto = avaliarServicoService.update(dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletebyid(@PathVariable Integer id) {
        avaliarServicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

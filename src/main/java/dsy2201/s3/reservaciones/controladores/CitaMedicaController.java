package dsy2201.s3.reservaciones.controladores;

import dsy2201.s3.reservaciones.dto.CitaMedicaDTO;
import dsy2201.s3.reservaciones.dto.ErrorResponse;
import dsy2201.s3.reservaciones.modelos.CitaMedica;
import dsy2201.s3.reservaciones.servicios.CitaMedicaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas_medicas")
public class CitaMedicaController {

    private final CitaMedicaService service;

    public CitaMedicaController(CitaMedicaService service) {
        this.service = service;
    }

    // GET: http://localhost:8080/citas_medicas
    @GetMapping
    public List<CitaMedica> obtenerDisponibilidad() {
        return service.consultarDisponibilidad();
    }

    // POST: http://localhost:8080/citas_medicas
    @PostMapping
    public ResponseEntity<?> programarCita(@Valid @RequestBody CitaMedicaDTO dto) {
        CitaMedica creada = service.programarCita(dto);
        if (creada == null) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Error: Ya existe una cita activa en esa fecha y hora para esa especialidad."));
        }
        return ResponseEntity.ok(creada);
    }

    // DELETE: http://localhost:8080/citas_medicas/1
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelarCita(@PathVariable int id) {
        CitaMedica cancelada = service.cancelarCita(id);
        if (cancelada == null) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Error: Cita no encontrada o ya estaba cancelada."));
        }
        return ResponseEntity.ok(cancelada);
    }
}

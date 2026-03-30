package dsy2201.s3.reservaciones.controladores;

import dsy2201.s3.reservaciones.modelos.CitaMedica;
import dsy2201.s3.reservaciones.servicios.CitaMedicaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas_medicas") // Ruta base clara
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
    public String programarCita(@RequestBody CitaMedica nuevaCita) {
        return service.programarCita(nuevaCita);
    }

    // DELETE: http://localhost:8080/citas_medicas/1
    @DeleteMapping("/{id}")
    public String cancelarCita(@PathVariable int id) {
        return service.cancelarCita(id);
    }
}
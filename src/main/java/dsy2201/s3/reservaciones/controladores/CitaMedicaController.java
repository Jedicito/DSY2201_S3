package dsy2201.s3.reservaciones.controladores;

import dsy2201.s3.reservaciones.modelos.CitaMedica;
import dsy2201.s3.reservaciones.servicios.CitaMedicaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/citas_medicas")
public class CitaMedicaController {

    private final CitaMedicaService service;

    public CitaMedicaController(CitaMedicaService service) {
        this.service = service;
    }

    @GetMapping
    public List<CitaMedica> obtenerDisponibilidad() {
        return service.consultarDisponibilidad();
    }

    @PostMapping
    public String programarCita(@Valid @RequestBody CitaMedica nuevaCita) { 
        return service.programarCita(nuevaCita);
    }

    @DeleteMapping("/{id}")
    public String cancelarCita(@PathVariable int id) {
        return service.cancelarCita(id);
    }
}
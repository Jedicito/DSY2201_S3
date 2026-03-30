package dsy2201.s3.reservaciones.servicios;

import dsy2201.s3.reservaciones.modelos.CitaMedica;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CitaMedicaService {

    private List<CitaMedica> citas = new ArrayList<>();

    public CitaMedicaService() {
        citas.add(new CitaMedica(1, "Juan Pérez",    "Traumatología",  LocalDateTime.of(2026, 4, 15, 10,  0), true));
        citas.add(new CitaMedica(2, "María López",   "Cardiología",    LocalDateTime.of(2026, 4, 15, 11, 30), true));
        citas.add(new CitaMedica(3, "Carlos Díaz",   "Pediatría",      LocalDateTime.of(2026, 4, 16,  9,  0), false));
        citas.add(new CitaMedica(4, "Ana Martínez",  "Dermatología",   LocalDateTime.of(2026, 4, 17, 14,  0), true));
        citas.add(new CitaMedica(5, "Luis Herrera",  "Neurología",     LocalDateTime.of(2026, 4, 18, 16, 30), true));
        citas.add(new CitaMedica(6, "Sofía Torres",  "Oftalmología",   LocalDateTime.of(2026, 4, 21,  8, 30), false));
        citas.add(new CitaMedica(7, "Diego Ramírez", "Odontología",    LocalDateTime.of(2026, 4, 22, 15,  0), true));
        citas.add(new CitaMedica(8, "Valentina Ríos","Ginecología",    LocalDateTime.of(2026, 4, 23, 10, 30), true));
    }

    // Retorna solo las citas activas
    public List<CitaMedica> consultarDisponibilidad() {
        List<CitaMedica> citasActivas = new ArrayList<>();
        for (CitaMedica cita : citas) {
            if (cita.isActiva()) {
                citasActivas.add(cita);
            }
        }
        return citasActivas;
    }

    public String programarCita(CitaMedica nuevaCita) {

        for (CitaMedica cita : citas) {
            // Verificar ID duplicado
            if (cita.getId() == nuevaCita.getId()) {
                return "Error: El ID de la cita ya está registrado.";
            }
            // Verificar conflicto de horario (solo contra citas activas)
            if (cita.isActiva() && cita.getFechaHora().equals(nuevaCita.getFechaHora()) && cita.getEspecialidad().equals(nuevaCita.getEspecialidad())) {
                return "Error: Ya existe una cita activa en esa fecha y hora.";
            }
        }

        nuevaCita.setActiva(true);
        citas.add(nuevaCita);
        return "Cita programada con éxito.";
    }

    public String cancelarCita(int id) {
        for (CitaMedica cita : citas) {
            if (cita.getId() == id) {
                if (!cita.isActiva()) {
                    return "La cita ya se encontraba cancelada.";
                }
                cita.setActiva(false);
                return "Cita cancelada correctamente.";
            }
        }
        return "Error: No se encontró la cita con ID " + id;
    }
}
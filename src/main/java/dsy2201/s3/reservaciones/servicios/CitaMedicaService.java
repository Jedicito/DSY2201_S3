package dsy2201.s3.reservaciones.servicios;


import dsy2201.s3.reservaciones.modelos.CitaMedica;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitaMedicaService {
    private List<CitaMedica> citas = new ArrayList<>();

    public CitaMedicaService() {
        citas.add(new CitaMedica(1, "Juan Perez", "2026-04-15", "10:00", true));
        citas.add(new CitaMedica(2, "Maria Lopez", "2026-04-15", "11:30", true));
        citas.add(new CitaMedica(3, "Carlos Diaz", "2026-04-16", "09:00", false));
    }

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
        if (nuevaCita.getPaciente() == null || nuevaCita.getPaciente().trim().isEmpty()) {
            return "Error: El nombre del paciente es obligatorio.";
        }
        for (CitaMedica cita : citas) {
            if (cita.getFecha().equals(nuevaCita.getFecha()) && cita.getHora().equals(nuevaCita.getHora()) && cita.isActiva()) {
                return "Error: Ya existe una cita activa en esa fecha y hora.";
            }
            if (cita.getId() == nuevaCita.getId()) {
                return "Error: El ID de la cita ya está registrado.";
            }
        }
        
        nuevaCita.setActiva(true); // Forzamos que nazca activa
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
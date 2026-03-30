package dsy2201.s3.reservaciones.modelos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CitaMedica {
    private int id;

    @NotBlank(message = "El nombre del paciente es obligatorio")
    private String paciente;

    @NotBlank(message = "La especialidad médica es obligatoria")
    private String especialidad;

    @NotNull(message = "La fecha y hora de la cita son obligatorias")
    @FutureOrPresent(message = "La cita no puede ser en el pasado")
    private LocalDateTime fechaHora; //"2026-03-30T14:30:00"
    
    private boolean activa;

    // Constructor vacío OBLIGATORIO para que Spring Boot convierta el JSON a objeto
    public CitaMedica() {
    }

    // Constructor con parámetros
    public CitaMedica(int id, String paciente, String especialidad, LocalDateTime fechaHora, boolean activa) {
        this.id = id;
        this.paciente = paciente;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.activa = activa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
}
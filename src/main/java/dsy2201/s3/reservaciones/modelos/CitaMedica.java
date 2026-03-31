package dsy2201.s3.reservaciones.modelos;

import java.time.LocalDateTime;

public class CitaMedica {

    private int id;
    private String paciente;
    private String especialidad;
    private LocalDateTime fechaHora;
    private boolean activa;

    public CitaMedica() {}

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
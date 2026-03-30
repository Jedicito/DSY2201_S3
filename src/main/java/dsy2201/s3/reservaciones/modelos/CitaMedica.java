package dsy2201.s3.reservaciones.modelos;


public class CitaMedica {
    private int id;
    private String paciente;
    private String fecha;
    private String hora;
    private boolean activa;

    public CitaMedica(int id, String paciente, String fecha, String hora, boolean activa) {
        this.id = id;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.activa = activa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
}
package dsy2201.s3.reservaciones.modelos;

public class OrdenCompra {

    private int id;
    private String producto;
    private Integer cantidad;
    private String estado;

    public OrdenCompra() {}

    public OrdenCompra(int id, String producto, int cantidad, String estado) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
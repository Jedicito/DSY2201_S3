package dsy2201.s3.reservaciones.modelos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrdenCompra {
    private int id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String producto;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad mínima debe ser 1")
    private Integer cantidad;

    @NotBlank(message = "El estado de la orden es obligatorio")
    private String estado; 

    public OrdenCompra(){}

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
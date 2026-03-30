package dsy2201.s3.reservaciones.servicios;


import dsy2201.s3.reservaciones.modelos.OrdenCompra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenCompraService {
    private List<OrdenCompra> ordenes = new ArrayList<>();

    public OrdenCompraService() {
        ordenes.add(new OrdenCompra(1, "Saco Alimento Perro 15kg", 2, "Enviado"));
        ordenes.add(new OrdenCompra(2, "Arena para Gatos", 5, "Pendiente"));
        ordenes.add(new OrdenCompra(3, "Juguete Hueso Goma", 1, "Entregado"));
    }

    public List<OrdenCompra> obtenerTodas() {
        return ordenes;
    }

    public OrdenCompra consultarEstado(int id) {
        for (OrdenCompra orden : ordenes) {
            if (orden.getId() == id) {
                return orden;
            }
        }
        return null;
    }

    // Ahora recibe el objeto completo armado desde el JSON
    public String crearOrden(OrdenCompra nuevaOrden) {
        if (nuevaOrden.getProducto() == null || nuevaOrden.getProducto().trim().isEmpty()) {
            return "Error: El producto no puede estar vacío.";
        }
        if (nuevaOrden.getCantidad() <= 0) {
            return "Error: La cantidad debe ser mayor a 0.";
        }
        for (OrdenCompra orden : ordenes) {
            if (orden.getId() == nuevaOrden.getId()) {
                return "Error: Ya existe una orden con el ID " + nuevaOrden.getId();
            }
        }
        
        nuevaOrden.setEstado("Pendiente"); // Forzamos el estado inicial
        ordenes.add(nuevaOrden);
        return "Orden creada con éxito.";
    }
}
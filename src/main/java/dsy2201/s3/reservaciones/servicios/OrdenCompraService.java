package dsy2201.s3.reservaciones.servicios;

import dsy2201.s3.reservaciones.modelos.OrdenCompra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenCompraService {

    private List<OrdenCompra> ordenes = new ArrayList<>();

    public OrdenCompraService() {
        ordenes.add(new OrdenCompra(1, "Laptop Dell",        5,  "pendiente"));
        ordenes.add(new OrdenCompra(2, "Mouse Inalámbrico",  12, "aprobada"));
        ordenes.add(new OrdenCompra(3, "Teclado Mecánico",   8,  "pendiente"));
        ordenes.add(new OrdenCompra(4, "Monitor 27 pulgadas",3,  "cancelada"));
        ordenes.add(new OrdenCompra(5, "Silla Ergonómica",   6,  "aprobada"));
        ordenes.add(new OrdenCompra(6, "Auriculares Bluetooth", 10, "pendiente"));
        ordenes.add(new OrdenCompra(7, "Webcam HD",          4,  "aprobada"));
        ordenes.add(new OrdenCompra(8, "Disco SSD 1TB",      7,  "cancelada"));
    }

    // Retorna todas las órdenes
    public List<OrdenCompra> listarOrdenes() {
        return ordenes;
    }

    public String crearOrden(OrdenCompra nuevaOrden) {
        for (OrdenCompra orden : ordenes) {
            if (orden.getId() == nuevaOrden.getId()) {
                return "Error: Ya existe una orden con ese ID.";
            }
        }
        nuevaOrden.setEstado("pendiente"); // Toda orden nueva nace como pendiente
        ordenes.add(nuevaOrden);
        return "Orden creada con éxito.";
    }

    public String cancelarOrden(int id) {
        for (OrdenCompra orden : ordenes) {
            if (orden.getId() == id) {
                if (orden.getEstado().equals("cancelada")) {
                    return "La orden ya se encontraba cancelada.";
                }
                orden.setEstado("cancelada");
                return "Orden cancelada correctamente.";
            }
        }
        return "Error: No se encontró la orden con ID " + id;
    }
}
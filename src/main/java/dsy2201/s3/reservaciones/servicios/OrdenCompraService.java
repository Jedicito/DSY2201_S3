package dsy2201.s3.reservaciones.servicios;

import dsy2201.s3.reservaciones.dto.OrdenCompraDTO;
import dsy2201.s3.reservaciones.modelos.OrdenCompra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenCompraService {

    private List<OrdenCompra> ordenes = new ArrayList<>();

    public OrdenCompraService() {
        ordenes.add(new OrdenCompra(1, "Croquetas Premium Perro",    5,  "pendiente"));
        ordenes.add(new OrdenCompra(2, "Arena para Gato",            12, "aprobada"));
        ordenes.add(new OrdenCompra(3, "Juguete Ratón Gato",         8,  "pendiente"));
        ordenes.add(new OrdenCompra(4, "Cama Ortopédica Perro",      3,  "cancelada"));
        ordenes.add(new OrdenCompra(5, "Correa Retráctil",           6,  "aprobada"));
        ordenes.add(new OrdenCompra(6, "Shampoo Antipulgas",         10, "pendiente"));
        ordenes.add(new OrdenCompra(7, "Comedero Automático",        4,  "aprobada"));
        ordenes.add(new OrdenCompra(8, "Vitaminas para Mascota",     7,  "cancelada"));
    }

    // Retorna todas las órdenes — ya es JSON por defecto al estar en un @RestController
    public List<OrdenCompra> listarOrdenes() {
        return ordenes;
    }

    // Recibe DTO, devuelve el modelo creado
    public OrdenCompra crearOrden(OrdenCompraDTO dto) {

        OrdenCompra nuevaOrden = new OrdenCompra();
        nuevaOrden.setId(ordenes.size() + 1); 
        nuevaOrden.setProducto(dto.getProducto());
        nuevaOrden.setCantidad(dto.getCantidad());
        nuevaOrden.setEstado("pendiente");

        ordenes.add(nuevaOrden);
        return nuevaOrden;
    }

    // Devuelve la orden cancelada
    public OrdenCompra cancelarOrden(int id) {
        for (OrdenCompra orden : ordenes) {
            if (orden.getId() == id) {
                if (orden.getEstado().equals("cancelada")) {
                    return null; // Lo manejamos en el controlador
                }
                orden.setEstado("cancelada");
                return orden;  // Devuelve el objeto actualizado → se serializa a JSON
            }
        }
        return null;
    }
}
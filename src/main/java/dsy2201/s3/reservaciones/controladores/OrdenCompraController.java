package dsy2201.s3.reservaciones.controladores;


import dsy2201.s3.reservaciones.modelos.OrdenCompra;
import dsy2201.s3.reservaciones.servicios.OrdenCompraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes_compra") // Ruta base clara
public class OrdenCompraController {

    private final OrdenCompraService service;

    public OrdenCompraController(OrdenCompraService service) {
        this.service = service;
    }

    // GET: http://localhost:8080/ordenes_compra
    @GetMapping
    public List<OrdenCompra> listarOrdenes() {
        return service.obtenerTodas();
    }

    // GET: http://localhost:8080/ordenes_compra/1/estado
    @GetMapping("/{id}/estado")
    public OrdenCompra consultarEstado(@PathVariable int id) {
        return service.consultarEstado(id);
    }

    // POST: http://localhost:8080/ordenes_compra
    // El @RequestBody transforma el JSON que envíes en un objeto Java automáticamente
    @PostMapping
    public String crearOrden(@RequestBody OrdenCompra nuevaOrden) {
        return service.crearOrden(nuevaOrden);
    }
}
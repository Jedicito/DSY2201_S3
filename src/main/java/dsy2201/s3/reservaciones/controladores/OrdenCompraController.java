package dsy2201.s3.reservaciones.controladores;

import dsy2201.s3.reservaciones.modelos.OrdenCompra;
import dsy2201.s3.reservaciones.servicios.OrdenCompraService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes_compra")
public class OrdenCompraController {

    private final OrdenCompraService service;

    public OrdenCompraController(OrdenCompraService service) {
        this.service = service;
    }

    // GET: http://localhost:8080/ordenes_compra
    @GetMapping
    public List<OrdenCompra> listarOrdenes() {
        return service.listarOrdenes();
    }

    // POST: http://localhost:8080/ordenes_compra
    @PostMapping
    public String crearOrden(@Valid @RequestBody OrdenCompra nuevaOrden) {
        return service.crearOrden(nuevaOrden);
    }

    // DELETE: http://localhost:8080/ordenes_compra/1
    @DeleteMapping("/{id}")
    public String cancelarOrden(@PathVariable int id) {
        return service.cancelarOrden(id);
    }
}
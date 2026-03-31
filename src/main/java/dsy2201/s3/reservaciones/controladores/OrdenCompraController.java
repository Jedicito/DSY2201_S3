package dsy2201.s3.reservaciones.controladores;

import dsy2201.s3.reservaciones.dto.ErrorResponse;
import dsy2201.s3.reservaciones.dto.OrdenCompraDTO;
import dsy2201.s3.reservaciones.modelos.OrdenCompra;
import dsy2201.s3.reservaciones.servicios.OrdenCompraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> crearOrden(@Valid @RequestBody OrdenCompraDTO dto) {
        OrdenCompra creada = service.crearOrden(dto);
        return ResponseEntity.ok(creada);
    }

    // DELETE: http://localhost:8080/ordenes_compra/1
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelarOrden(@PathVariable int id) {
        OrdenCompra cancelada = service.cancelarOrden(id);

        if (cancelada == null) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Error: Orden no encontrada o ya estaba cancelada."));  // 400
        }
        return ResponseEntity.ok(cancelada);
    }
}

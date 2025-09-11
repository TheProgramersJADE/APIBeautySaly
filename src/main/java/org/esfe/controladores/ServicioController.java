package org.esfe.controladores;

import org.esfe.dtos.Servicios.servicioGuardar;
import org.esfe.dtos.Servicios.servicioModificar;
import org.esfe.dtos.Servicios.servicioSalida;
import org.esfe.servicios.interfaces.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private IServicioService servicioService;

    @GetMapping
    public ResponseEntity<Page<servicioSalida>> mostrarTodosPaginados(Pageable pageable) {
        Page<servicioSalida> servicios = servicioService.obtenerTodosPaginados(pageable);
        if (servicios.hasContent()) {
            return ResponseEntity.ok(servicios);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<servicioSalida>> mostrarTodos() {
        List<servicioSalida> servicios = servicioService.obtenerTodos();
        if (servicios.isEmpty()) {
            return ResponseEntity.ok(servicios);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<servicioSalida> buscarPorId(@PathVariable Integer id) {
        servicioSalida servicios = servicioService.obtnerPorId(id);
        if (servicios != null) {
            return ResponseEntity.ok(servicios);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<servicioSalida> crear(@RequestBody servicioGuardar servicioGuardar) {
        servicioSalida servicios = servicioService.crear(servicioGuardar);

            return ResponseEntity.ok(servicios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<servicioSalida> editar(@PathVariable Integer id, @RequestBody servicioModificar servicioModificar) {
        servicioSalida servicios = servicioService.editar(servicioModificar);

        return ResponseEntity.ok(servicios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        servicioService.eliminarPorId(id);

        return ResponseEntity.ok("El servicio se a eliminqdo commentator");
    }
}


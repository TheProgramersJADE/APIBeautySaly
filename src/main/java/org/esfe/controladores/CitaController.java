package org.esfe.controladores;

import org.esfe.dtos.Citas.citaGuardar;
import org.esfe.dtos.Citas.citaModificar;
import org.esfe.dtos.Citas.citaSalida;
import org.esfe.servicios.interfaces.ICitaService;
import org.esfe.servicios.interfaces.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    @Autowired
    private ICitaService citaService;

    @Autowired
    private IServicioService servicioService;

    @GetMapping
    public ResponseEntity<Page<citaSalida>> mostrarTodosPaginados(Pageable pageable) {
        Page<citaSalida> citas = citaService.obtenerTodosPaginados(pageable);
        if (citas.hasContent()) {
            return ResponseEntity.ok(citas);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<citaSalida>> mostrarTodos() {
        List<citaSalida> citas = citaService.obtenerTodos();
        if (citas.isEmpty()) {
            return ResponseEntity.ok(citas);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<citaSalida> buscarPorId(@PathVariable Integer id) {
        citaSalida citas = citaService.obtnerPorId(id);
        if (citas != null) {
            return ResponseEntity.ok(citas);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<citaSalida> crear(@RequestBody citaGuardar citaGuardar) {
        citaSalida citas = citaService.crear(citaGuardar);

        return ResponseEntity.ok(citas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<citaSalida> editar(@PathVariable Integer id, @RequestBody citaModificar citaModificar) {
        citaSalida citas = citaService.editar(citaModificar);

        return ResponseEntity.ok(citas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        citaService.eliminarPorId(id);

        return ResponseEntity.ok("La cita se a eliminado commentator");
    }
}

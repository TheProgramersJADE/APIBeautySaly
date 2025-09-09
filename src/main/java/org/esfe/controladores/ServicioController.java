package org.esfe.controladores;

import org.esfe.dtos.servicio.servicioSalida;
import org.esfe.servicios.interfaces.IServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private IServicioService servicioService;

    @GetMapping
    public ResponseEntity<Page<servicioSalida>> mostrarTodosPaginados(Pageable pageable){
        Page<servicioSalida> servicios = servicioService.obtenerTodosPaginados(pageable);
        if (servicios.hasContent()) {
            return ResponseEntity.ok(servicios);
        }
        return  ResponseEntity.notFound().build();
    }
}

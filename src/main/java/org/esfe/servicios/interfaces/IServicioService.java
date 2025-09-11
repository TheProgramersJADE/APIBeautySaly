package org.esfe.servicios.interfaces;

import org.esfe.dtos.Servicios.servicioGuardar;
import org.esfe.dtos.Servicios.servicioModificar;
import org.esfe.dtos.Servicios.servicioSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IServicioService {

    List<servicioSalida> obtenerTodos();

    Page<servicioSalida> obtenerTodosPaginados(Pageable pageable);

    servicioSalida obtnerPorId(Integer id);

    servicioSalida crear(servicioGuardar servicioGuardar);

    servicioSalida editar(servicioModificar servicioModificar);

    void eliminarPorId(Integer id);
}
package org.esfe.servicios.interfaces;

import org.esfe.dtos.Citas.citaGuardar;
import org.esfe.dtos.Citas.citaModificar;
import org.esfe.dtos.Citas.citaSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICitaService {

    List<citaSalida> obtenerTodos();

    Page<citaSalida> obtenerTodosPaginados(Pageable pageable);

    citaSalida obtnerPorId(Integer id);

    citaSalida crear(citaGuardar citaGuardar);

    citaSalida editar(citaModificar citaModificar);

    void eliminarPorId(Integer id);
}

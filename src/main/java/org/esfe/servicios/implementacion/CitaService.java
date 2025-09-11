package org.esfe.servicios.implementacion;

import org.esfe.dtos.Citas.citaGuardar;
import org.esfe.dtos.Citas.citaModificar;
import org.esfe.dtos.Citas.citaSalida;
import org.esfe.dtos.Servicios.servicioSalida;
import org.esfe.modelos.Cita;
import org.esfe.modelos.Servicio;
import org.esfe.repositorios.ICitaRepository;
import org.esfe.servicios.interfaces.ICitaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService implements ICitaService {

    @Autowired
    private ICitaService citaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<citaSalida> obtenerTodos() {
        return null;
    }

    @Override
    public Page<citaSalida> obtenerTodosPaginados(Pageable pageable) {
        return null;
    }

    @Override
    public citaSalida obtnerPorId(Integer id) {
        return null;
    }

    @Override
    public citaSalida crear(citaGuardar citaGuardar) {
        return null;
    }

    @Override
    public citaSalida editar(citaModificar citaModificar) {
        return null;
    }

    @Override
    public void eliminarPorId(Integer id) {

    }
}

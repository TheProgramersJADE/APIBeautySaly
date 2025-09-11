package org.esfe.servicios.implementacion;

import org.esfe.dtos.Servicios.servicioGuardar;
import org.esfe.dtos.Servicios.servicioModificar;
import org.esfe.dtos.Servicios.servicioSalida;
import org.esfe.modelos.Servicio;
import org.esfe.repositorios.IServicioRepository;
import org.esfe.servicios.interfaces.IServicioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioService implements IServicioService {

    @Autowired
    private IServicioRepository servicioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<servicioSalida> obtenerTodos() {
        List<Servicio> servicios = servicioRepository.findAll();
        return servicios.stream()
                .map(servicio -> modelMapper.map(servicio, servicioSalida.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<servicioSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Servicio> page = servicioRepository.findAll(pageable);

        List<servicioSalida> serviciosDto  = page.stream()
                .map(servicio -> modelMapper.map(servicio, servicioSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(serviciosDto, page.getPageable(), page.getTotalElements());
    }

    @Override
    public servicioSalida obtnerPorId(Integer id) {
        return  modelMapper.map(servicioRepository.findById(id).get(), servicioSalida.class);
    }

    @Override
    public servicioSalida crear(servicioGuardar servicioGuardar) {
        Servicio servicio= servicioRepository.save(modelMapper.map(servicioGuardar, Servicio.class));
        return modelMapper.map(servicio, servicioSalida.class);
    }

    @Override
    public servicioSalida editar(servicioModificar servicioModificar) {
        Servicio servicio = servicioRepository.save(modelMapper.map(servicioModificar, Servicio.class));
        return modelMapper.map(servicio, servicioSalida.class);

    }

    @Override
    public void eliminarPorId(Integer id) {
        servicioRepository.deleteById(id);

    }
}

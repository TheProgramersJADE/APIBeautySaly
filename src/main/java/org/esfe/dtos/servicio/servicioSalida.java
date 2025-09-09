package org.esfe.dtos.servicio;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;

@Getter
@Setter
public class servicioSalida implements Serializable {
    private Integer id;
    private String nombreServicio;
    private String descripcion;
    private Duration duracion;
    private BigDecimal precio;
}

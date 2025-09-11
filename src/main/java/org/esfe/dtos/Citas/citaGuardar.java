package org.esfe.dtos.Citas;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class citaGuardar implements Serializable {
    private String cliente;
    private String telefono;
    private LocalDateTime fechaHora;
    private String trabajador;
}

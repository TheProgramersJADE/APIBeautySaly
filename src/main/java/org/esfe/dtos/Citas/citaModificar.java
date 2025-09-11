package org.esfe.dtos.Citas;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class citaModificar implements Serializable {
    private Integer id;
    private String cliente;
    private String telefono;
    private LocalDateTime fechaHora;
    private String trabajador;
}

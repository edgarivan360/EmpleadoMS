package com.wombats.empleado.to.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@ToString
public class EmpleadoRespuesta {

    private Long id;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;

}

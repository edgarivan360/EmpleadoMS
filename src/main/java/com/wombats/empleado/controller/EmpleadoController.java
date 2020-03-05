package com.wombats.empleado.controller;

import com.wombats.empleado.service.EmpleadoService;
import com.wombats.empleado.to.request.EmpleadoPeticion;
import com.wombats.empleado.to.response.EmpleadoRespuesta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping("/{id}")
    public EmpleadoRespuesta buscarEmpleado(@PathVariable(value = "id") Long id, HttpServletResponse response) throws IOException {
        try {
            return empleadoService.buscarEmpleado(id);
        } catch (NoSuchElementException exception) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.sendError(HttpServletResponse.SC_NOT_FOUND,exception.getMessage());
            return null;
        }
    }

    @PostMapping
    public void guardarEmpleado(@RequestBody EmpleadoPeticion empleadoPeticion) {
        empleadoService.guardarEmpleado(empleadoPeticion);
    }

}

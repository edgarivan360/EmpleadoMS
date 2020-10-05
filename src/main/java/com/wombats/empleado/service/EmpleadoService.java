package com.wombats.empleado.service;

import com.wombats.empleado.model.EmpleadoEntity;
import com.wombats.empleado.persistence.repository.EmpleadoEntityRepository;
import com.wombats.empleado.to.request.EmpleadoPeticion;
import com.wombats.empleado.to.response.EmpleadoRespuesta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class EmpleadoService {

    private final EmpleadoEntityRepository empleadoEntityRepository;

    public EmpleadoRespuesta buscarEmpleado(Long id) {
        EmpleadoEntity empleado = empleadoEntityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("El empleado %d no existe", id)));
        return EmpleadoRespuesta
        		.builder()
                .id(empleado.getId())
                .nombreCompleto(new StringBuilder(empleado.getNombre()).append(" ")
                        .append(empleado.getApellidoPaterno()).append(" ")
                        .append(empleado.getApellidoMaterno()).toString())
                .fechaNacimiento(empleado.getFechaNacimiento())
                .build();
    }

    public void guardarEmpleado(EmpleadoPeticion empleadoPeticion) {
        empleadoEntityRepository.saveAndFlush(
                EmpleadoEntity
                .builder()
                .nombre(empleadoPeticion.getNombre())
                .apellidoPaterno(empleadoPeticion.getApellidoPaterno())
                .apellidoMaterno(empleadoPeticion.getApellidoMaterno())
                .fechaNacimiento(LocalDate.parse(empleadoPeticion.getFechaNacimiento()))
                .build()
        );
    }


}

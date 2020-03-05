package com.wombats.empleado.persistence.repository;

import com.wombats.empleado.model.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface EmpleadoEntityRepository extends JpaRepository<EmpleadoEntity, Long> {
}

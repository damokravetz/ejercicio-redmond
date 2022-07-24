package com.redmond.ejercicioredmond.repositories;

import org.springframework.data.repository.CrudRepository;
import com.redmond.ejercicioredmond.models.Empleado;

import java.util.Optional;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    public abstract Optional<Empleado> findByNombre(String nombre);
}

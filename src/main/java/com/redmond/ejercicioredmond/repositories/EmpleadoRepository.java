package com.redmond.ejercicioredmond.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.redmond.ejercicioredmond.models.Empleado;

import java.util.Map;
import java.util.Optional;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    public abstract Optional<Empleado> findByNombre(String nombre);
    @Query("select sum(e.sueldo) as total, avg(e.sueldo) as promedio from Empleado e")
    public abstract Map<String,Double> reporteSueldos();
    @Query("select count(e) from Empleado e")
    public abstract Integer countEmpleados();
    public abstract Page<Empleado> findAll(Pageable pageable);
}

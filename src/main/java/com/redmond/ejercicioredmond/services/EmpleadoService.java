package com.redmond.ejercicioredmond.services;

import com.redmond.ejercicioredmond.models.Empleado;
import com.redmond.ejercicioredmond.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public Map<String,Integer> obtenerSobreSueldo(String nombre){
        Optional<Empleado> optEmpleado=empleadoRepository.findByNombre(nombre);
        if(optEmpleado.isPresent()){
            return calcularCantidadBilletes(optEmpleado.get().getSueldo());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empleado no encontrado");
        }
    }

    private Map<String,Integer> calcularCantidadBilletes(Double cantidad){
        ArrayList<Integer> denom= new ArrayList<Integer>(Arrays.asList(100, 50, 20, 10, 5, 2, 1));
        Map<String,Integer> res=new HashMap<>();
        Double resto=cantidad;
        for (Integer a: denom) {
            Integer cociente= (int)(resto / a);
            resto=resto%a;
            res.put(a.toString(), cociente);
        }
        return res;
    }

}

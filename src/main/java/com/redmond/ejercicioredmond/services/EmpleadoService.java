package com.redmond.ejercicioredmond.services;

import com.redmond.ejercicioredmond.models.Empleado;
import com.redmond.ejercicioredmond.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        //Denominaciones podrian estar guardadas en una tabja de base de datos y ser consultadas en orden descendente
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

    public Map<String,Double> reporteSueldos(){
        Map<String,Double> reporte=new HashMap<>(empleadoRepository.reporteSueldos());
        Integer cantEmpleados= empleadoRepository.countEmpleados();
        reporte.put("empleados", cantEmpleados.doubleValue());
        return reporte;
    }

    public Page<Empleado> listaEmpleados(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("nombre").ascending());
        return empleadoRepository.findAll(pageable);
    }

}

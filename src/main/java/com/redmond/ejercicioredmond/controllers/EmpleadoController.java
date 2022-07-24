package com.redmond.ejercicioredmond.controllers;

import com.redmond.ejercicioredmond.models.Empleado;
import com.redmond.ejercicioredmond.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping(path = "sueldo")
    public ResponseEntity<Map<String,Integer>> sobreSueldo(@RequestParam String nombre){
        return new ResponseEntity<>(empleadoService.obtenerSobreSueldo(nombre), HttpStatus.OK);
    }

    @GetMapping(path = "reporte")
    public ResponseEntity<Map<String,Double>> reporteSueldos(){
        return new ResponseEntity<>(empleadoService.reporteSueldos(), HttpStatus.OK);
    }

    @GetMapping(path = "lista")
    public ResponseEntity<Page<Empleado>> listaEmpleados(@RequestParam Integer page, @RequestParam Integer size){
        return new ResponseEntity<>(empleadoService.listaEmpleados(page, size), HttpStatus.OK);
    }

}

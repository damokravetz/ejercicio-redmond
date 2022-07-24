package com.redmond.ejercicioredmond.controllers;

import com.redmond.ejercicioredmond.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Map<String,Integer> sobreSueldo(@RequestParam String nombre){
        return empleadoService.obtenerSobreSueldo(nombre);
    }

}

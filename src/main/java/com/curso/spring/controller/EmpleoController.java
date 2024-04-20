package com.curso.spring.controller;

import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Empleos;
import com.curso.spring.service.EmpleoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleos")
@Tag(name = "Empleos")
public class EmpleoController {

    @Autowired
    private EmpleoService empleoService;

    @GetMapping("/getEmpleos")
    @Operation(summary = "Operacion para obtener los datos de Empleos")
    public List<Empleos> obtenerEmpleos(){
        return empleoService.findAllEmpleos();
    }

    @PostMapping("/postEmpleos")
    @Operation(summary = "Operacion para guardar los datos de Empleos")
    public ResponseEntity<Empleos> guardarEmpleos(@RequestBody Empleos empleos){
        return empleoService.guardarEmpleo(empleos);
    }

    @DeleteMapping("/deleteEmpleos/{id}")
    @Operation(summary = "Operacion para eliminar los datos de empleos por id")
    public void eliminarEmpleo(@PathVariable Long id){
        empleoService.eliminarEmpleo(id);
    }

    @PutMapping("/putEmpleos")
    @Operation(summary = "Operacion para actualizar los datos de empleos")
    public ResponseEntity<?> updateEmpleo(@RequestBody EmpleoRequest request) throws Exception{
        return empleoService.updateEmpleo(request);
    }
}

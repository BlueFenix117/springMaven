package com.curso.spring.controller;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.model.Direcciones;
import com.curso.spring.service.DireccionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
@Tag(name = "Direcciones")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @GetMapping("/getDirecciones")
    @Operation(summary = "Operacion para obtener los datos de Direcciones")
    public List<Direcciones> obtenerDirecciones(){
        return direccionService.findAllDirecciones();
    }

    @PostMapping("/postDirecciones")
    @Operation(summary = "Operacion para guardar los datos de Direcciones")
    public ResponseEntity<Direcciones> guardarDirecciones(@RequestBody Direcciones direcciones){
        return direccionService.guardarDirecciones(direcciones);
    }

    @DeleteMapping("/deleteDirecciones/{id}")
    @Operation(summary = "Operacion para eliminar los datos de direcciones por id")
    public void eliminarDireccion(@PathVariable Long id){
        direccionService.eliminarDireccion(id);
    }

    @PutMapping("/putDirecciones")
    @Operation(summary = "Operacion para actualizar los datos de direcciones")
    public ResponseEntity<?> updateDireccion(@RequestBody DireccionRequest request) throws Exception{
        return direccionService.updateDireccion(request);
    }
}

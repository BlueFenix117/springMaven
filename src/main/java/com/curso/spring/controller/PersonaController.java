package com.curso.spring.controller;

import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import com.curso.spring.service.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@Tag(name = "Personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/getPersonas")
    @Operation(summary = "Operacion para obtener los datos de personas")
    public List<Personas> obtenerPersonas(){
        return personaService.findAllPersons();
    }

    @PostMapping("/postPersonas")
    @Operation(summary = "Operacion para guardar los datos de personas")
    public ResponseEntity<Personas> guardarPersonas(@RequestBody Personas personas){
        return personaService.guardarPersona(personas);
    }

    @PostMapping("/postPersonasAlternativo")
    @Operation(summary = "Operacion para guardar los datos de personas")
    public ResponseEntity<Personas> guardarPersonasAlternativo(@RequestBody PersonaRequest personas){
        return personaService.guardarPersonaAlternativo(personas);
    }
}

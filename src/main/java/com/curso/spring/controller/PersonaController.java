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

    @GetMapping("/getPersonas/{Id}")
    @Operation(summary = "Operacion para obtener los datos de personas por id")
    public Personas buscarPersonaId(@PathVariable Long id){
        return personaService.buscarPersonaId(id);
    }

    @PutMapping("/putPersonas")
    @Operation(summary = "Operacion para actualizar los datos de personas")
    public ResponseEntity<Object> updatePersona(@RequestBody PersonaRequest request){

        return personaService.updatePersona(request);
    }

    @DeleteMapping("/deletePersonas/{id}")
    @Operation(summary = "Operacion para eliminar los datos de personas por id")
    public void eliminarPersona(@PathVariable Long id){
        personaService.eliminarPersona(id);
    }

    @GetMapping("/getPersonas/genero/{genero}")
    @Operation(summary = "Operacion para obtener los nombres de personas por genero")
    public List<String> getNombrePersonaByGenero(@PathVariable String genero){
        return personaService.personasByGenero(genero);
    }


    @GetMapping("/getPersonas/info/{id}")
    @Operation(summary = "Operacion para obtener la informacion de personas por Id")
    public ResponseEntity<Object> getInfoPersonas(@PathVariable Integer id){
        return personaService.getInfoPersonas(id);
    }

    @PostMapping("/Person/save/native")
    @Operation(summary = "Operacion para guardar la informacion de personas de forma nativa")
    public ResponseEntity<?> savePersonaNative(@RequestBody PersonaRequest request){
        return personaService.savePersonasNative(request);
    }

    @PutMapping("/Person/native-update")
    @Operation(summary = "Operacion para actualizar la informacion de personas de forma nativa")
    public ResponseEntity<?> updatePersonNative(@RequestBody PersonaRequest request) throws Exception {
        return personaService.updatePersonasNative(request);
    }

    @DeleteMapping("/Person/native-delete/{id}")
    @Operation(summary = "Operacion para eliminar la informacion de personas de forma nativa")
    public boolean deletePersonNative(@PathVariable int id) throws Exception{
        return personaService.deletePersonNative(id);
    }
}

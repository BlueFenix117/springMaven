package com.curso.spring.controller;

import com.curso.spring.dto.Persona;
import com.curso.spring.service.EjerciciosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso-spring")

@Slf4j
public class HelloWorldController {
    @Autowired
    private EjerciciosService ejerciciosService;

    @GetMapping("/Hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hola/{nombre}")
    public String holaMundoCustom(@PathVariable String nombre){
        log.info("El nombre que se envia desde la url es: " + nombre);
        return "Hola Mundo " + nombre;
    }

    @PostMapping("/persona")
    public Persona datospersona(@RequestBody Persona persona) {

        return persona;
    }

    @GetMapping("/nombres")
    public List<String> getNombres(){
        return ejerciciosService.getNombres();
    }
}

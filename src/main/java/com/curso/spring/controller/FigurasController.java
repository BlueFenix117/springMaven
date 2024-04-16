package com.curso.spring.controller;


import com.curso.spring.dto.RectanguloDto;
import com.curso.spring.dto.TrianguloDto;
import com.curso.spring.service.RectanguloService;
import com.curso.spring.service.TrianguloService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Figuras")
@Slf4j
@CrossOrigin

@Tag(name = "Figuras")
public class FigurasController {

    @Autowired
    private RectanguloService rectanguloService;

    @PostMapping("/area-rectangulo")
    public double calcularAreaRectangulo(@RequestBody RectanguloDto request){
        return rectanguloService.calcularAreaRectangulo(request);
    }

    @Autowired
    private TrianguloService trianguloService;
    @PostMapping("/area-triangulo")
    public double calcularAreaTriangulo(@RequestBody TrianguloDto request){
        return trianguloService.calcularAreaTriangulo(request);
    }

    @GetMapping("/area-circulo/{radio}")
    public double calcularAreaCirculo(@PathVariable double radio){
        final double pi=3.1416;
        return pi*(radio*radio);
    }
}
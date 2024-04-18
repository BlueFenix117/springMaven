package com.curso.spring.controller;


import com.curso.spring.dto.CirculoDto;
import com.curso.spring.dto.PoligonoDto;
import com.curso.spring.dto.RectanguloDto;
import com.curso.spring.dto.TrianguloDto;
import com.curso.spring.service.CirculoService;
import com.curso.spring.service.PoligonoService;
import com.curso.spring.service.RectanguloService;
import com.curso.spring.service.TrianguloService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Operacion para calcular Area de un rectangulo")
    public double calcularAreaRectangulo(@RequestBody RectanguloDto request){
        return rectanguloService.calcularAreaRectangulo(request);
    }

    @Autowired
    private TrianguloService trianguloService;
    @PostMapping("/area-triangulo")
    @Operation(summary = "Operacion para calcular Area de un triangulo")
    public double calcularAreaTriangulo(@RequestBody TrianguloDto request){
        return trianguloService.calcularAreaTriangulo(request);
    }

    @Autowired
    private CirculoService circuloService;
    @PostMapping("/area-circulo")
    @Operation(summary = "Operacion para calcular Area de un circulo")
    public double calcularAreaCirculo(@RequestBody CirculoDto request){
        return circuloService.calcularAreaCirculo(request);
    }

    @Autowired
    private PoligonoService poligonoService;
    @PostMapping("/area-poligono")
    @Operation(summary = "Operacion para calcular Area de un poligono regular")
    public double calcularAreaPoligono(@RequestBody PoligonoDto request){
        return poligonoService.calcularAreaPoligono(request);
    }
}
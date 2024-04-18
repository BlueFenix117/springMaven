package com.curso.spring.service.impl;

import com.curso.spring.dto.PoligonoDto;
import com.curso.spring.service.PoligonoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PoligonoServiceImpl implements PoligonoService {
    @Override
    public double calcularAreaPoligono(PoligonoDto request){
        double area = (request.getPerimetro()*request.getApotema())/2;

        log.info("El area del poligono es: "+area);
        return area;
    }
}

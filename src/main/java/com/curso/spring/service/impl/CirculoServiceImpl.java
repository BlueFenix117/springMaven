package com.curso.spring.service.impl;

import com.curso.spring.dto.CirculoDto;
import com.curso.spring.service.CirculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CirculoServiceImpl implements CirculoService {
    @Override
    public double calcularAreaCirculo(CirculoDto request){
        final double  Pi = 3.1416;
        double area = Pi*(request.getRadio()*request.getRadio());

        log.info("El area del circulo es: "+area);
        return area;
    }
}

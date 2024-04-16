package com.curso.spring.service.impl;

import com.curso.spring.dto.TrianguloDto;
import com.curso.spring.service.TrianguloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TrianguloServiceImpl implements TrianguloService {
    @Override
    public double calcularAreaTriangulo(TrianguloDto request){
        double area = (request.getBase()* request.getAltura())/2;

        log.info("El area del triangulo es: "+area);
        return area;
    }
}

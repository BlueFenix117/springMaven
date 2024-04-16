package com.curso.spring.service.impl;

import com.curso.spring.dto.RectanguloDto;
import com.curso.spring.service.RectanguloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RectanguloServiceImpl implements RectanguloService {
    @Override
    public double calcularAreaRectangulo(RectanguloDto request){
        double area = request.getBase()* request.getAltura();

        log.info("El area del rectangulo es: "+area);
        return area;
    }
}

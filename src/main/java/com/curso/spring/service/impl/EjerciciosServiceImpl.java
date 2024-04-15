package com.curso.spring.service.impl;

import com.curso.spring.service.EjerciciosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EjerciciosServiceImpl implements EjerciciosService {
    @Override
    public List<String> getNombres() {
        log.info("Entro al metodo get nombres");

        List<String> listaNombres = new ArrayList<>();
        List<String> response = new ArrayList<>();

        listaNombres.add("Heriberto");
        listaNombres.add("Edgar");
        listaNombres.add("Octavio");
        listaNombres.add("Silvia");

        for (String nombre: listaNombres){
            if (nombre.contains("o") || nombre.contains("O")){
                log.info("Entro al if de la lista nombres");
                response.add(nombre);
            }
        }

        return response;
    }
}

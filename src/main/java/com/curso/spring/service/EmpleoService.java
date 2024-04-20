package com.curso.spring.service;

import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Empleos;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmpleoService {
    List<Empleos> findAllEmpleos();

    ResponseEntity<Empleos> guardarEmpleo(Empleos empleos);

    void eliminarEmpleo(Long id);

    ResponseEntity<?> updateEmpleo(EmpleoRequest request) throws Exception;
}

package com.curso.spring.service;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.model.Direcciones;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DireccionService {
    List<Direcciones> findAllDirecciones();

    ResponseEntity<Direcciones> guardarDirecciones(Direcciones direcciones);

    void eliminarDireccion(Long id);

    ResponseEntity<?> updateDireccion(DireccionRequest request) throws Exception;
}

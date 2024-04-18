package com.curso.spring.service;

import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {

    List<Personas> findAllPersons();

    ResponseEntity<Personas> guardarPersona(Personas personas);
    ResponseEntity<Personas> guardarPersonaAlternativo(PersonaRequest request);
    Personas buscarPersonaId(Long id);

    ResponseEntity<Object> updatePersona(PersonaRequest request);

    void eliminarPersona(Long id);

    List<String> personasByGenero(String genero);

    ResponseEntity<Object> getInfoPersonas(Integer id);
}

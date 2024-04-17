package com.curso.spring.service.impl;

import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import com.curso.spring.repository.PersonasRepository;
import com.curso.spring.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaService personaService;
    @Autowired
    private PersonasRepository personasRepository;
    @Override
    public List<Personas> findAllPersons() {
        return personasRepository.findAll();
    }

    @Override
    public ResponseEntity<Personas> guardarPersona(Personas personas) {
        return ResponseEntity.ok(personasRepository.save(personas));
    }

    @Override
    public ResponseEntity<Personas> guardarPersonaAlternativo(PersonaRequest request) {

        Personas personas = new Personas();
        personas.setNombre(request.getNombre());
        personas.setEdad(request.getEdad());
        personas.setGenero(request.getGenero());
        personas.setDireccionId(request.getDireccionId());
        personas.setEmpleoId(request.getEmpleoId());


        return ResponseEntity.ok(personasRepository.save(personas));
    }
}

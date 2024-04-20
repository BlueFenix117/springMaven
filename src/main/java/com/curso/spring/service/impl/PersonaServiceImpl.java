package com.curso.spring.service.impl;

import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.dto.response.DatosPersonaResponse;
import com.curso.spring.model.Personas;
import com.curso.spring.repository.PersonasRepository;
import com.curso.spring.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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
    @Override
    public Personas buscarPersonaId(Long id){

        Optional<Personas> datosPersona = personasRepository.findById(id);

        return datosPersona.get();
    }

    @Override
    public ResponseEntity<Object> updatePersona(PersonaRequest request) {

        ResponseEntity<Object> response = null;

        Optional<Personas> existePersona = personasRepository.findById(request.getPersonaId());

        if (existePersona.isPresent()) {

            Personas personas = new Personas();
            personas.setPersonaId(request.getPersonaId());
            personas.setNombre(request.getNombre());
            personas.setEdad(request.getEdad());
            personas.setGenero(request.getGenero());
            //personas.setDireccionId(request.getDireccionId());
            //personas.setEmpleoId(request.getEmpleoId());

            response = ResponseEntity.ok(personasRepository.save(personas));
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la Persona para actualizar");
        }
        return response;
    }

    @Override
    public void eliminarPersona(Long id) {
        personasRepository.deleteById(id);
    }

    @Override
    public List<String> personasByGenero(String genero){
        return personasRepository.personasByGenero(genero);
    }

    @Override
    public ResponseEntity<Object> getInfoPersonas(@PathVariable Integer id){

        ResponseEntity<Object> response = null;
        try{

            Optional<DatosPersonaResponse> infoPersona = Optional.ofNullable(personasRepository.getInfoPersona(id));
            if(infoPersona.isPresent()){
                response = ResponseEntity.ok(infoPersona.get());
            }else{
                response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontraron los datos de la persona con id: " +id);
            }
        } catch(Exception e){
            log.error("Error el metodo getInfoPersona " +e.getMessage());
        }

        return response;
    }

    @Transactional
    @Override
    public ResponseEntity<?> savePersonasNative(PersonaRequest request) {

        ResponseEntity<?> response = null;

        try {
            log.info("Request guardar" + request);
            Integer result = personasRepository.saveNativePerson(request);

            if (result > 0) {
                response = ResponseEntity.ok().body("Guardado exitodso");
            } else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un error al intentar insertar");
            }

        } catch (Exception e) {
            log.error("Error en motodo savePersonaNative" + e.getMessage());
        }
        return response;
    }

    @Transactional
    @Override
    public ResponseEntity<?> updatePersonasNative(PersonaRequest request) throws Exception {

        ResponseEntity<?> response = null;
        try {
            Integer result = personasRepository.updateNativePerson(request);
            if (result > 0) {
                response = ResponseEntity.ok().body("Actualizacion exitosa");
            } else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un error al intentar actualizar");
            }

        } catch (Exception e) {
            throw new Exception("Error en meotdo updatePersonNative" + e.getMessage());
        }
        return response;
    }

    //Metodo para borrar persona
    @Override
    @Transactional
    public boolean deletePersonNative(int id) throws Exception {

        boolean response = false;

        try {
            personasRepository.deleteNativePerson(id);
            response = true;

        } catch (Exception e) {
            throw new Exception("Error al eliminar" + e.getMessage());
        }

        return response;
    }
}

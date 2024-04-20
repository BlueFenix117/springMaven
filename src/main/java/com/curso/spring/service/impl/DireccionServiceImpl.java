package com.curso.spring.service.impl;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.model.Direcciones;
import com.curso.spring.repository.DireccionesRepository;
import com.curso.spring.service.DireccionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionService direccionService;

    @Autowired
    private DireccionesRepository direccionesRepository;

    @Override
    public List<Direcciones> findAllDirecciones(){
        return direccionesRepository.findAll();
    }

    @Override
    public ResponseEntity<Direcciones> guardarDirecciones(Direcciones direcciones) {
        return ResponseEntity.ok(direccionesRepository.save(direcciones));
    }
    @Override
    public void eliminarDireccion(Long id) {
        direccionesRepository.deleteById(id);
    }

    @Transactional
    @Override
    public ResponseEntity<?> updateDireccion(DireccionRequest request) throws Exception {

        ResponseEntity<?> response = null;
        try {
            Integer result = direccionesRepository.updateDireccion(request);
            if (result > 0) {
                response = ResponseEntity.ok().body("Actualizacion exitosa");
            } else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un error al intentar actualizar");
            }

        } catch (Exception e) {
            throw new Exception("Error en meotdo updateEmpleo" + e.getMessage());
        }
        return response;
    }
}

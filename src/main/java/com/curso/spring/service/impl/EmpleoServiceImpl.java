package com.curso.spring.service.impl;

import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Empleos;
import com.curso.spring.repository.EmpleosRepository;
import com.curso.spring.service.EmpleoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class EmpleoServiceImpl implements EmpleoService{

    @Autowired
    private EmpleoService empleoService;

    @Autowired
    private EmpleosRepository empleosRepository;

    @Override
    public List<Empleos> findAllEmpleos(){
        return empleosRepository.findAll();
    }

    @Override
    public ResponseEntity<Empleos> guardarEmpleo(Empleos empleos) {
        return ResponseEntity.ok(empleosRepository.save(empleos));
    }
    @Override
    public void eliminarEmpleo(Long id) {
        empleosRepository.deleteById(id);
    }

    @Transactional
    @Override
    public ResponseEntity<?> updateEmpleo(EmpleoRequest request) throws Exception {

        ResponseEntity<?> response = null;
        try {
            Integer result = empleosRepository.updateEmpleo(request);
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

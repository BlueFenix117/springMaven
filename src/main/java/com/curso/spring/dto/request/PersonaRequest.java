package com.curso.spring.dto.request;

import lombok.Data;

@Data
public class PersonaRequest {

    private Long personaId;


    private String nombre;


    private Integer edad;


    private String genero;


    private Integer direccionId;


    private Integer empleoId;
}

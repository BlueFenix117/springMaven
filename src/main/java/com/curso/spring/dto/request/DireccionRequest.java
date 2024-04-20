package com.curso.spring.dto.request;

import lombok.Data;

@Data
public class DireccionRequest {

    private Long direccionId;
    private String calle;
    private String ciudad;
    private String estado;
    private String codigoPostal;
}

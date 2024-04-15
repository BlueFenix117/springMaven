package com.curso.spring.dto;


import lombok.*;

@Data

public class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    private String genero;
}

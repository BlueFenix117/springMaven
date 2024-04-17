package com.curso.spring.dto;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data

public class Persona {
    @NotBlank(message = "El campo no puede estar vacio") //Ambas
    private String nombre;

    @NotBlank
    private String apellidoPaterno;
    private String apellidoMaterno;

    @Pattern(regexp = "\\d{2}", message = "El campo solo admite numeros enteros de 2 digitos")
    private String edad;
    private String genero;

    @Email
    private String email;
}

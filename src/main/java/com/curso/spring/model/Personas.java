package com.curso.spring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "personas")
@Data
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "persona_id", nullable = false)
    private Long personaId;

    @Column(name= "nombre", nullable = false)
    private String nombre;

    @Column(name= "edad")
    private Integer edad;

    @Column(name= "genero")
    private String genero;

    @Column(name= "direccion_id")
    private Integer direccionId;

    @Column(name= "empleo_id")
    private Integer empleoId;
}

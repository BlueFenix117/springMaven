package com.curso.spring.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "empleos")
@Data
public class Empleos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "empleo_id", nullable = false)
    private Long empleoId;

    @Column(name= "titulo")
    private String titulo;

    @Column(name= "empresa")
    private String empresa;

    @Column(name= "salario")
    private BigDecimal salario;
}

package com.curso.spring.service;

import com.curso.spring.dto.response.Posts;

import java.util.List;

public interface EjerciciosService {
    List<String> getNombres();

    Posts getPost(int id);
}

package com.curso.spring.repository;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.model.Direcciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionesRepository extends JpaRepository<Direcciones, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE direcciones SET calle= :#{#request.calle} WHERE direccion_id = :#{#request.direccionId}", nativeQuery = true)
    Integer updateDireccion(@Param("request") DireccionRequest request);
}

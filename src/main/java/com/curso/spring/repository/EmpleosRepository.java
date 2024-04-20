package com.curso.spring.repository;

import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Empleos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleosRepository extends JpaRepository<Empleos, Long> {
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE empleos SET titulo= :#{#request.titulo} WHERE empleo_id = :#{#request.empleoId}", nativeQuery = true)
    Integer updateEmpleo(@Param("request") EmpleoRequest request);
}

package com.seguranca_digital.sistema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.seguranca_digital.sistema.domain.SistemaModel;

public interface SistemaRepository extends JpaRepository<SistemaModel, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT s FROM SistemaModel s "
            + "WHERE UPPER(s.descricao) LIKE %:descricao% "
            + "AND UPPER(s.sigla) LIKE %:sigla% "
            + "AND UPPER(s.email) LIKE %:email% ")
    List<SistemaModel> listar(
            @Param("descricao") String descricao,
            @Param("sigla") String sigla,
            @Param("email") String email
    );

}
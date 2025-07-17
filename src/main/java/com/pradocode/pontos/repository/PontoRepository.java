package com.pradocode.pontos.repository;

import com.pradocode.pontos.model.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PontoRepository extends JpaRepository<Ponto, Long> {

    @Query("SELECT p FROM Ponto p WHERE p.usuario.id = :idUsuario AND p.dataHora BETWEEN :inicioDoDia AND :fimDoDia")
    List<Ponto> listarPontosEmUmDia(@Param("idUsuario") Long idUsuario,
                                    @Param("inicioDoDia") LocalDateTime inicioDoDia,
                                    @Param("fimDoDia") LocalDateTime fimDoDia);
}

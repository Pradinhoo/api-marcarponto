package com.pradocode.pontos.repository;

import com.pradocode.pontos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long idUsuario);
    Optional<Usuario> findByIdAndEmAtividadeTrue(Long idUsuario);
    Optional<Usuario> findByCpf(String cpf);
    List<Usuario> findAllByEmAtividadeTrue();
    List<Usuario> findAllByEmAtividadeFalse();
}

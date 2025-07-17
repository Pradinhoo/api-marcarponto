package com.pradocode.pontos.controller;

import com.pradocode.pontos.dto.CadastrarUsuarioDTO;
import com.pradocode.pontos.model.Usuario;
import com.pradocode.pontos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    private final UsuarioService usuarioService;

    @PostMapping
    ResponseEntity<String> cadastrarNovoUsuario(@RequestBody @Valid CadastrarUsuarioDTO cadastrarUsuarioDTO) {
        Long idUsuario = usuarioService.cadastrarNovoUsuario(cadastrarUsuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Novo usuário cadastrado com sucesso! O ID do usuário é : " + idUsuario);
    }

    @GetMapping
    ResponseEntity<List<Usuario>> listarUsuariosAtivos() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarUsuariosAtivos());
    }

    @GetMapping("/desativados")
    ResponseEntity<List<Usuario>> listarUsuariosDesativados() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarUsuariosNaoAtivos());
    }

    @PatchMapping("/{idUsuario}/desativar")
    ResponseEntity<String> desativarUsuario(@PathVariable Long idUsuario) {
        usuarioService.desativarUsuario(idUsuario);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário com ID: " + idUsuario + " desativado com sucesso!");
    }

    @PatchMapping("/{idUsuario}/ativar")
    ResponseEntity<String> ativarUsuario(@PathVariable Long idUsuario) {
        usuarioService.ativarUsuario(idUsuario);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário com ID: " + idUsuario + " ativado com sucesso!");
    }
}

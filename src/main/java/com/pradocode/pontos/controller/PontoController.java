package com.pradocode.pontos.controller;

import com.pradocode.pontos.dto.MarcarPontoDTO;
import com.pradocode.pontos.service.PontoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ponto")
public class PontoController {

    private final PontoService pontoService;

    public PontoController(PontoService pontoService) {
        this.pontoService = pontoService;
    }

    @PostMapping
    public ResponseEntity<String> marcarPonto(@RequestBody MarcarPontoDTO marcarPontoDTO) {
        pontoService.marcarPonto(marcarPontoDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Ponto marcado com sucesso!");
    }
}

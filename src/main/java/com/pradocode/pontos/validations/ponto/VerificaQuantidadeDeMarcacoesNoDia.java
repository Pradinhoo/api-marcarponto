package com.pradocode.pontos.validations.ponto;

import com.pradocode.pontos.dto.MarcarPontoDTO;
import com.pradocode.pontos.exception.ponto.QuatroPontosJaMarcadosException;
import com.pradocode.pontos.model.Ponto;
import com.pradocode.pontos.repository.PontoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class VerificaQuantidadeDeMarcacoesNoDia implements VerificacaoMarcarPonto {

    private final PontoRepository pontoRepository;

    public VerificaQuantidadeDeMarcacoesNoDia(PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
    }

    public void verificacao(MarcarPontoDTO marcarPontoDTO) {
        LocalDate hoje = LocalDate.now();
        LocalDateTime inicioDoDia = hoje.atStartOfDay();
        LocalDateTime fimDoDia = hoje.atTime(23, 59, 59);

        List<Ponto> listaDePonto = pontoRepository.listarPontosEmUmDia(marcarPontoDTO.idUsuario(), inicioDoDia, fimDoDia);

        if (listaDePonto.size() >= 4) {
            throw new QuatroPontosJaMarcadosException();
        }
    }
}

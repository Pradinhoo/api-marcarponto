package com.pradocode.pontos.validations.ponto;

import com.pradocode.pontos.dto.MarcarPontoDTO;
import com.pradocode.pontos.exception.ponto.HorarioNaoPermitidoException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class VerificaSeEstaMarcandoAntesDasOito implements VerificacaoMarcarPonto {

    public void verificacao(MarcarPontoDTO marcarPontoDTO) {
        LocalDateTime oitoDaManha = LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 0));

        if (LocalDateTime.now().isBefore(oitoDaManha)) {
            throw new HorarioNaoPermitidoException();
        }
    }
}

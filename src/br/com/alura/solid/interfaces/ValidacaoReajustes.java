package br.com.alura.solid.interfaces;

import br.com.alura.solid.model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajustes {
    void validar(Funcionario funcionario, BigDecimal aumento);
}

package br.com.alura.solid.service;

import br.com.alura.solid.ValidacaoException;
import br.com.alura.solid.interfaces.ValidacaoReajustes;
import br.com.alura.solid.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajustes {

    public void validar(Funcionario funcionario, BigDecimal aumento){
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
    }

}

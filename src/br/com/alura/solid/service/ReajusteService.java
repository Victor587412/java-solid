package br.com.alura.solid.service;

import br.com.alura.solid.interfaces.ValidacaoReajustes;
import br.com.alura.solid.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    private List<ValidacaoReajustes> validacoes;

    public ReajusteService(List<ValidacaoReajustes> validacoes){
        this.validacoes = validacoes;
    }

    public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento){
        this.validacoes.forEach(validacao -> validacao.validar(funcionario,aumento));
        BigDecimal salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }

}

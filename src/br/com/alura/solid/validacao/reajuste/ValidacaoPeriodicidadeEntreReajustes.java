package br.com.alura.solid.validacao.reajuste;

import br.com.alura.solid.ValidacaoException;
import br.com.alura.solid.interfaces.ValidacaoReajustes;
import br.com.alura.solid.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajustes {

    public void validar(Funcionario funcionario, BigDecimal aumento){
        LocalDate ultimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();
        long mesesDesdeUlimoReajuste = ChronoUnit.MONTHS.between(ultimoReajuste, dataAtual);
        if (mesesDesdeUlimoReajuste < 6) {
            throw new ValidacaoException("Intervalor entre reajustes deve ser maior que 6 meses");
        }
    }

}

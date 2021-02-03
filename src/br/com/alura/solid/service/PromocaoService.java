package br.com.alura.solid.service;

import br.com.alura.solid.ValidacaoException;
import br.com.alura.solid.model.Cargo;
import br.com.alura.solid.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida){
        Cargo cargo = funcionario.getCargo();
        if(Cargo.GERENTE == cargo){
            throw new ValidacaoException("Gerente não podem ser promovidos");
        }
        if(metaBatida){
           Cargo novoCargo = cargo.getProximoCargo();
           funcionario.promover(novoCargo);
        }else{
            throw new ValidacaoException("Funcionario não bateu a meta");
        }
    }

}

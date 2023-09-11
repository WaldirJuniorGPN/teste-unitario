package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {
    public void reajustar(Funcionario funcionario, Desempenho desempenho) {
        var reajuste = desempenho.percentualReajuste();
        var salarioAtual = funcionario.getSalario();
        funcionario.setSalario(salarioAtual.add(salarioAtual.multiply(reajuste)).setScale(2, RoundingMode.HALF_UP));
    }
}

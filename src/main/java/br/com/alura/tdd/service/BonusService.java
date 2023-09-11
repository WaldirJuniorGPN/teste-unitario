package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.infra.FuncionarioException;
import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));

        if (funcionario.getSalario().compareTo(new BigDecimal("10000")) > 0) {
			throw new FuncionarioException("Não é possível conceder bônus a funcionarios que recebem acima de 10mil reais");
        }

        //		if (valor.compareTo(new BigDecimal("1000")) > 0) {
//			valor = BigDecimal.ZERO;
//		}
        return valor.setScale(2, RoundingMode.HALF_UP);
    }

}

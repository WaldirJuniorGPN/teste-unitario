package br.com.alura.tdd.service;

import br.com.alura.tdd.infra.FuncionarioException;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    void bonusDevariaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        var service = new BonusService();
        assertThrows(FuncionarioException.class, () -> service.calcularBonus(new Funcionario("Junior", LocalDate.now(), new BigDecimal("50000"))));
    }

    @Test
    void bonusDevariaSer10PorCentoDoSalario() {
        var service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Junior", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

    @Test
    void bonusDevariaSer10PorCentoDoSalarioMesmoQuandoOSalarioForMenorDe10Mil() {
        var service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Junior", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }
}

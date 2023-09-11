package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    private void inicializar() {
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("Junior", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    void reajusteDeveriaSerDe3PorcentoQuandoODesempenhoForADesejar() {
        this.reajusteService.reajustar(this.funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), this.funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDe15PorcentoQuandoODesempenhoForADesejar() {
        this.reajusteService.reajustar(this.funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), this.funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDe20PorcentoQuandoODesempenhoForADesejar() {
        this.reajusteService.reajustar(this.funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), this.funcionario.getSalario());
    }
}

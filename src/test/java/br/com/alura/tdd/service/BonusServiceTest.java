package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {

        BonusService bonusService = new BonusService();
        //BigDecimal bonus = bonusService.calcularBonus(new Funcionario("André", LocalDate.now(), new BigDecimal("25000")));
        //Testando lançamento de Exceptions
        assertThrows(IllegalArgumentException.class,
                ()->bonusService.calcularBonus(new Funcionario("André", LocalDate.now(), new BigDecimal("25000"))));

        //assertEquals(BigDecimal.ZERO, bonus);

        try {
            bonusService.calcularBonus(new Funcionario("André", LocalDate.now(), new BigDecimal("25000")));
            fail("Não deu a exception, teste falhou!");
        }catch (Exception e){
            assertEquals("Funcionário com salário maior do que R$10.000 não pode receber bonus! ",e.getMessage());
        }


    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {

        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("André", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.0"), bonus);

    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {

        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("André", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), bonus);

    }




}
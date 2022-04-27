package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach //Diz ao JUnit que este método deve ser chamado antes de inicializar cada um dos métodos de teste.
    //também existe o @AfterEach que é chamado após finalizar cada um os métodos
    //@BeforeAll executa uma UNICA vez antes de todos - deve ser static
    //@AfterAll executa uma UNICA vez depois de todos - deve ser static
    public void inicializar() {
        System.out.println("Método iniciado");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("André", LocalDate.now(), new BigDecimal("1000.00"));
    }

    //exemplo de @AfterEach
    @AfterEach
    public void finalizar(){
        System.out.println("Método Finalizado");
    }

    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("ANTES DE TODOS");
    }

    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Depois DE TODOS");
    }

    @Test
    public void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());

    }

    @Test
    public void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());

    }

    @Test
    public void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());

    }

}

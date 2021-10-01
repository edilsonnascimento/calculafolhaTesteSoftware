import model.Cargo;
import model.Funcionario;
import org.junit.Before;
import org.junit.Test;
import service.CalculaFolha;

import static org.junit.Assert.*;


import java.math.BigDecimal;

public class CalculaFolhaTest {

    private Funcionario funcionario;

    @Before
    public void init(){
        funcionario = new Funcionario();
        funcionario.setNome("Pedro");
        funcionario.setEmail("pedro@empresati.com.br");
    }

    //Desenvolvedor
    @Test
    public void deveCalcularDescontoParaDesenvovedorMaiorTresMil(){
        funcionario.setCargo(Cargo.DESENVOLVEDOR);
        funcionario.setSalarioBase(new BigDecimal("5000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.DESENVOLVEDOR, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("4000.0"));
    }

    @Test
    public void deveCalcularDescontoParaDesenvovedorIgualTresMil(){
        funcionario.setCargo(Cargo.DESENVOLVEDOR);
        funcionario.setSalarioBase(new BigDecimal("3000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.DESENVOLVEDOR, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("2400.0"));
    }

    @Test
    public void deveCalcularDescontoParaDesenvovedorMenorTresMil(){
        funcionario.setCargo(Cargo.DESENVOLVEDOR);
        funcionario.setSalarioBase(new BigDecimal("2999"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.DESENVOLVEDOR, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("2699.1"));
    }

    //DBA
    @Test
    public void deveCalcularDescontoParaDBAMaiorDoisMil(){
        funcionario.setCargo(Cargo.DBA);
        funcionario.setSalarioBase(new BigDecimal("5000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.DBA, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("3750.00"));
    }

    @Test
    public void deveCalcularDescontoParaDBAIgualDoisMil(){
        funcionario.setCargo(Cargo.DBA);
        funcionario.setSalarioBase(new BigDecimal("2000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.DBA, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("1500.00"));
    }

    @Test
    public void deveCalcularDescontoParaDBAMenorDoisMil(){
        funcionario.setCargo(Cargo.DBA);
        funcionario.setSalarioBase(new BigDecimal("1000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.DBA, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("850.00"));
    }

    //TESTADOR
    @Test
    public void deveCalcularDescontoParaTestadorMaiorDoisMil(){
        funcionario.setCargo(Cargo.TESTADOR);
        funcionario.setSalarioBase(new BigDecimal("5000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.TESTADOR, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("3750.00"));

    }

    @Test
    public void deveCalcularDescontoParaTestadorIgualDoisMil(){
        funcionario.setCargo(Cargo.TESTADOR);
        funcionario.setSalarioBase(new BigDecimal("2000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.TESTADOR, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("1500.00"));
    }

    @Test
    public void deveCalcularDescontoParaTestadorMenorDoisMil(){
        funcionario.setCargo(Cargo.TESTADOR);
        funcionario.setSalarioBase(new BigDecimal("1000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.TESTADOR, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("850.00"));
    }

    //GERENTE
    @Test
    public void deveCalcularDescontoParaGrenteMaiorCincoMil(){
        funcionario.setCargo(Cargo.GERENTE);
        funcionario.setSalarioBase(new BigDecimal("10000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.GERENTE, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("7000.0"));
    }

    @Test
    public void deveCalcularDescontoParaGrenteIgualCincoMil(){
        funcionario.setCargo(Cargo.GERENTE);
        funcionario.setSalarioBase(new BigDecimal("5000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.GERENTE, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("3500.0"));
    }

    @Test
    public void deveCalcularDescontoParaGrenteMenorCincoMil(){
        funcionario.setCargo(Cargo.GERENTE);
        funcionario.setSalarioBase(new BigDecimal("1000"));
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);

        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();

        assertEquals(Cargo.GERENTE, funcionario.getCargo());
        assertEquals(salarioLiquido, new BigDecimal("800.0"));
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveCalcularDescontoDeFuncionarioInexistente(){
        funcionario.setCargo(null);
        CalculaFolha calculaFolha = new CalculaFolha(funcionario);
        BigDecimal salarioLiquido = calculaFolha.calcularSalarioLiquido();
    }
}

package service;

import model.Funcionario;

import java.math.BigDecimal;

public class CalculaFolha {

    private Funcionario funcionario;

    public CalculaFolha(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public BigDecimal calcularSalarioLiquido() throws FuncionarioException{
        BigDecimal valorDesconto = new Descontos(funcionario).calcularValorDesconto();
        return funcionario.getSalarioBase().subtract(valorDesconto);
    }

}

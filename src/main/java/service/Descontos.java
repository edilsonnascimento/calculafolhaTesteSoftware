package service;

import model.Funcionario;

import java.math.BigDecimal;

public class Descontos {

    private final static int EHMAIOR = 1;
    private final static int EHIGUAL = 0;
    private Funcionario funcionario;

    public Descontos(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public BigDecimal calcularValorDesconto(){
        BigDecimal percentualDesconto = salarioMaiorOuIgual(funcionario.getCargo().getSalarioReferencia())?
                             new BigDecimal(funcionario.getCargo().getDescontoMaximo()):
                             new BigDecimal(funcionario.getCargo().getDescontoMinimo());
        return valorDesconto(percentualDesconto);
    }

    private boolean salarioMaiorOuIgual(BigDecimal salarioRefencia) {
        return (funcionario.getSalarioBase().compareTo(salarioRefencia) == EHMAIOR) ||
                funcionario.getSalarioBase().compareTo(salarioRefencia) == EHIGUAL;
    }

    private BigDecimal valorDesconto(BigDecimal percentualDesconto){
        return funcionario.getSalarioBase().multiply(percentualDesconto);
    }
}

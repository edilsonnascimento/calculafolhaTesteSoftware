package model;

import java.math.BigDecimal;

public enum Cargo {

    DESENVOLVEDOR("0.2", "0.1", "3000"),
    DBA("0.25", "0.15", "2000"),
    TESTADOR("0.25", "0.15", "2000"),
    GERENTE("0.3", "0.2", "5000");

    private String descontoMaximo;
    private String descontoMinimo;
    private String salarioReferencia;

    Cargo(String descontoMaximo, String descontMinimo, String salarioReferencia) {
        this.descontoMaximo = descontoMaximo;
        this.descontoMinimo = descontMinimo;
        this.salarioReferencia = salarioReferencia;
    }

    Cargo() {}

    public String getDescontoMaximo() {
        return descontoMaximo;
    }

    public String getDescontoMinimo() {
        return descontoMinimo;
    }

    public BigDecimal getSalarioReferencia() {
        return new BigDecimal(salarioReferencia);
    }
}

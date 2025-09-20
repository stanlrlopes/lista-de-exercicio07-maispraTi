package exercicio3;

import java.math.BigDecimal;

public class Gerente extends Funcionario {

    public Gerente(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        BigDecimal fatorBonus = new BigDecimal("0.20"); // 20%
        return this.salario.multiply(fatorBonus);
    }
}
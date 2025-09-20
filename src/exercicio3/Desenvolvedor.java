package exercicio3;

import java.math.BigDecimal;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, BigDecimal salario) {
        super(nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        BigDecimal fatorBonus = new BigDecimal("0.10"); // 10%
        return this.salario.multiply(fatorBonus);
    }
}
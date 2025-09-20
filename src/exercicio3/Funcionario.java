package exercicio3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Funcionario {
    protected String nome;
    protected BigDecimal salario;

    public Funcionario(String nome, BigDecimal salario) {
        this.nome = nome;
        // Validação para garantir que o salário seja sempre positivo
        if (salario == null || salario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O salário deve ser um valor positivo.");
        }
        this.salario = salario;
    }

    // Getters públicos para permitir a leitura dos atributos
    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public BigDecimal calcularBonus() {
        // Retorna 0 como padrão para um funcionário que não tem um bônus específico.
        return BigDecimal.ZERO;
    }
}
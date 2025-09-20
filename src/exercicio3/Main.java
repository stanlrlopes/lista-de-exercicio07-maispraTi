package exercicio3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Criando instâncias das classes concretas
        Gerente gerente = new Gerente("Ana Costa", new BigDecimal("12000.00"));
        Desenvolvedor dev1 = new Desenvolvedor("João Silva", new BigDecimal("7500.00"));
        Desenvolvedor dev2 = new Desenvolvedor("Maria Souza", new BigDecimal("8200.00"));

        // 2. Criando uma lista do tipo da SUPERCLASSE
        // Esta lista pode conter qualquer objeto que SEJA UM Funcionario
        List<Funcionario> funcionarios = new ArrayList<>();

        // Adicionando objetos das SUBCLASSES na mesma lista
        funcionarios.add(gerente);
        funcionarios.add(dev1);
        funcionarios.add(dev2);

        System.out.println("--- Calculando Bônus dos Funcionários ---");

        // 3. Percorrendo a lista e invocando o método polimorficamente
        for (Funcionario func : funcionarios) {
            BigDecimal bonus = func.calcularBonus();

            System.out.printf(
                    "Nome: %s, Salário: R$%.2f, Bônus: R$%.2f%n",
                    func.getNome(),
                    func.getSalario(),
                    bonus
            );
        }
    }
}
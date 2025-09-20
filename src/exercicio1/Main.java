package exercicio1;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Criando um Produto com Valores Válidos ---");

        // 1. Instanciando (criando) um objeto da classe Produto
        Produto produto1 = new Produto();

        // 2. Usando os setters para atribuir valores válidos
        produto1.setNome("Notebook Gamer");
        produto1.setPreco(new BigDecimal("5500.00")); // Para criar um BigDecimal, usamos String para precisão
        produto1.setQuantidadeEmEstoque(10);

        // 3. Usando os getters para ler e exibir os valores
        System.out.println("Nome: " + produto1.getNome());
        System.out.println("Preço: R$" + produto1.getPreco());
        System.out.println("Quantidade em Estoque: " + produto1.getQuantidadeEmEstoque());

        System.out.println("\n--- Tentando Atribuir Valores Inválidos ---");

        // 4. Tentando atribuir um preço negativo
        try {
            System.out.println("Tentando definir preço para -100...");
            produto1.setPreco(new BigDecimal("-100"));
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO CAPTURADO: " + e.getMessage());
        }

        // 5. Tentando atribuir um nome vazio
        try {
            System.out.println("\nTentando definir nome como vazio...");
            produto1.setNome("   "); // Um nome com apenas espaços
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO CAPTURADO: " + e.getMessage());
        }

        // 6. Tentando atribuir uma quantidade negativa
        try {
            System.out.println("\nTentando definir estoque como -5...");
            produto1.setQuantidadeEmEstoque(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO CAPTURADO: " + e.getMessage());
        }

        // 7. Exibindo os valores do produto para confirmar que não foram alterados
        System.out.println("\n--- Valores Finais do Produto (não devem ter mudado) ---");
        System.out.println("Nome: " + produto1.getNome());
        System.out.println("Preço: R$" + produto1.getPreco());
        System.out.println("Quantidade em Estoque: " + produto1.getQuantidadeEmEstoque());
    }
}

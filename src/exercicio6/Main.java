package exercicio6;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // 1. Criando os produtos
        Produto notebook = new Produto("Notebook Pro", new Dinheiro(new BigDecimal("8500.00"), Moeda.BRL));
        Produto mouse = new Produto("Mouse sem Fio", new Dinheiro(new BigDecimal("150.00"), Moeda.BRL));
        Produto teclado = new Produto("Teclado Mecânico", new Dinheiro(new BigDecimal("450.00"), Moeda.BRL));

        // 2. O fluxo imutável
        System.out.println("--- Iniciando o carrinho ---");
        Carrinho c1 = new Carrinho();
        System.out.println("C1 (vazio): " + c1);
        System.out.println("Hash do C1: " + System.identityHashCode(c1));

        System.out.println("\n--- Adicionando Notebook ---");
        Carrinho c2 = c1.adicionarItem(notebook, 1);
        System.out.println("C1 (original, não mudou): " + c1);
        System.out.println("C2 (novo carrinho): " + c2);
        System.out.println("Hash do C1: " + System.identityHashCode(c1));
        System.out.println("Hash do C2: " + System.identityHashCode(c2) + " (diferente de C1)");

        System.out.println("\n--- Adicionando Mouse e Teclado ---");
        Carrinho c3 = c2.adicionarItem(mouse, 2).adicionarItem(teclado, 1);
        System.out.println("C2 (não mudou): " + c2);
        System.out.println("C3 (novo carrinho): " + c3);
        System.out.println("Total do C3: " + c3.getTotal());

        System.out.println("\n--- Aplicando cupom de 10% ---");
        Carrinho c4 = c3.aplicarCupom(new BigDecimal("0.10"));
        System.out.println("C3 (sem cupom, não mudou): " + c3);
        System.out.println("C4 (com cupom): " + c4);
        System.out.println("Total do C4 com desconto: " + c4.getTotal());

        System.out.println("\n--- Removendo o Mouse ---");
        Carrinho c5 = c4.removerItem(mouse);
        System.out.println("C4 (não mudou): " + c4);
        System.out.println("C5 (final): " + c5);
        System.out.println("Total do C5: " + c5.getTotal());

        System.out.println("\n--- Tentando aplicar cupom inválido ---");
        try {
            c5.aplicarCupom(new BigDecimal("0.50")); // 50%
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO CAPTURADO: " + e.getMessage());
        }
    }
}
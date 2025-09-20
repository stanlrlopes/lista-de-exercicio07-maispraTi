package exercicio8;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Criando um pedido
        Pedido pedido = new Pedido(new BigDecimal("500.00"), "64260000");

        System.out.println("--- Testando Estratégias de Frete ---");

        // 1. Calculando com Sedex
        pedido.setEstrategiaFrete(new Sedex());
        System.out.printf("Valor do frete: R$%.2f%n%n", pedido.calcularFrete());

        // 2. TROCANDO a estratégia em TEMPO DE EXECUÇÃO para PAC
        pedido.setEstrategiaFrete(new Pac());
        System.out.printf("Valor do frete: R$%.2f%n%n", pedido.calcularFrete());

        // 3. Trocando para Retirada na Loja
        pedido.setEstrategiaFrete(new RetiradaNaLoja());
        System.out.printf("Valor do frete: R$%.2f%n%n", pedido.calcularFrete());

        System.out.println("--- Testando Estratégia Promocional com LAMBDA ---");
        // 4. Criando uma estratégia com uma expressão LAMBDA
        // "se o valor do pedido > 300, frete é grátis, senão, usa PAC"
        EstrategiaFrete fretePromocional = p -> {
            System.out.println("Calculando frete com estratégia promocional...");
            if (p.getValorTotal().compareTo(new BigDecimal("300.00")) > 0) {
                System.out.println("Pedido elegível para frete grátis!");
                return BigDecimal.ZERO;
            }
            // Se não for elegível, delega para a estratégia PAC
            return new Pac().calcular(p);
        };

        // Aplicando a estratégia lambda ao pedido
        pedido.setEstrategiaFrete(fretePromocional);
        System.out.printf("Valor do frete (pedido > 300): R$%.2f%n%n", pedido.calcularFrete());

        // Testando com um pedido menor
        Pedido pedidoPequeno = new Pedido(new BigDecimal("150.00"), "64260000");
        pedidoPequeno.setEstrategiaFrete(fretePromocional);
        System.out.printf("Valor do frete (pedido < 300): R$%.2f%n%n", pedidoPequeno.calcularFrete());

        System.out.println("--- Testando Validação de CEP ---");
        try {
            Pedido pedidoCepInvalido = new Pedido(new BigDecimal("200.00"), "CEP-INVALIDO");
            pedidoCepInvalido.setEstrategiaFrete(new Sedex());
            pedidoCepInvalido.calcularFrete();
        } catch (CepInvalidoException e) {
            System.out.println("ERRO CAPTURADO: " + e.getMessage());
        }
    }
}
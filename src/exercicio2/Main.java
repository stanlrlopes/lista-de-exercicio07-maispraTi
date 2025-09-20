package exercicio2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        // Criando um produto com valores iniciais
        Produto tv = new Produto();
        tv.setNome("Smart TV 50 Polegadas");
        tv.setPreco(new BigDecimal("2500.00"));
        tv.setQuantidadeEmEstoque(15);

        System.out.println("--- Testando Desconto Válido ---");
        System.out.println("Produto: " + tv.getNome());
        System.out.println("Preço Original: R$" + tv.getPreco());

        // Aplicando um desconto válido de 10%
        System.out.println("\nAplicando desconto de 10%...");
        tv.aplicarDesconto(10.0);

        // Arredondando para 2 casas decimais para exibição
        BigDecimal precoFormatado = tv.getPreco().setScale(2, RoundingMode.HALF_UP);
        System.out.println("Novo Preço com Desconto: R$" + precoFormatado);

        System.out.println("\n------------------------------------");

        System.out.println("\n--- Tentando Aplicar Desconto Inválido (60%) ---");
        System.out.println("Preço atual: R$" + precoFormatado);
        try {
            System.out.println("Tentando aplicar desconto de 60%...");
            tv.aplicarDesconto(60.0);
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO CAPTURADO: " + e.getMessage());
        }

        precoFormatado = tv.getPreco().setScale(2, RoundingMode.HALF_UP);
        System.out.println("Preço final (não deve ter mudado): R$" + precoFormatado);

        System.out.println("\n--- Tentando Aplicar Desconto Inválido (-5%) ---");
        try {
            System.out.println("Tentando aplicar desconto de -5%...");
            tv.aplicarDesconto(-5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("ERRO CAPTURADO: " + e.getMessage());
        }

        precoFormatado = tv.getPreco().setScale(2, RoundingMode.HALF_UP);
        System.out.println("Preço final (não deve ter mudado): R$" + precoFormatado);
    }
}
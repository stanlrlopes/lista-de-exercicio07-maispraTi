package exercicio5;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal valorDaCompra = new BigDecimal("250.00");

        System.out.println("--- Simulação de Pagamentos ---");

        // 1. Pagamento com Cartão de Crédito VÁLIDO
        FormaPagamento cartaoValido = new CartaoCredito("1111222233334444");
        processar(cartaoValido, valorDaCompra);

        // 2. Pagamento com Cartão de Crédito INVÁLIDO
        FormaPagamento cartaoInvalido = new CartaoCredito("1234");
        processar(cartaoInvalido, valorDaCompra);

        System.out.println("--------------------");

        // 3. Pagamento com Boleto VÁLIDO
        FormaPagamento boletoValido = new Boleto("123456789012345678901234567890123456789012345678");
        processar(boletoValido, valorDaCompra);

        // 4. Pagamento com Boleto INVÁLIDO
        FormaPagamento boletoInvalido = new Boleto("codigo-curto");
        processar(boletoInvalido, valorDaCompra);

        System.out.println("--------------------");

        // 5. Pagamento com Pix VÁLIDO
        FormaPagamento pixValido = new Pix("meu-email@gmail.com");
        processar(pixValido, valorDaCompra);

        // 6. Pagamento com Pix INVÁLIDO
        FormaPagamento pixInvalido = new Pix("  ");
        processar(pixInvalido, valorDaCompra);
    }

    // Método auxiliar para evitar repetição do try-catch
    private static void processar(FormaPagamento forma, BigDecimal valor) {
        try {
            // Usamos polimorfismo aqui. Não importa qual a forma de pagamento,
            // o método processarPagamento existe e funciona da mesma maneira.
            forma.processarPagamento(valor);
        } catch (PagamentoInvalidoException e) {
            System.out.println("FALHA: " + e.getMessage());
        } finally {
            // O bloco finally é sempre executado, com ou sem exceção.
            System.out.println();
        }
    }
}
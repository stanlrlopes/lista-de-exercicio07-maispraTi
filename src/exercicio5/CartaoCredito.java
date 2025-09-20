package exercicio5;

public class CartaoCredito extends FormaPagamento {
    private final String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        System.out.println("Validando Cartão de Crédito: " + numeroCartao);
        // Validação simples: o número do cartão deve ter 16 dígitos.
        if (numeroCartao == null || !numeroCartao.matches("\\d{16}")) {
            throw new PagamentoInvalidoException("Número de cartão de crédito inválido.");
        }
    }
}
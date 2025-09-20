package exercicio5;

public class Boleto extends FormaPagamento {
    private final String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        System.out.println("Validando Boleto: " + codigoBarras);
        // Validação simples: o código de barras deve ter 48 dígitos.
        if (codigoBarras == null || !codigoBarras.matches("\\d{48}")) {
            throw new PagamentoInvalidoException("Código de barras do boleto inválido.");
        }
    }
}
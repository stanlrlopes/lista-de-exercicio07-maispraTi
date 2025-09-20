package exercicio5;

public class Pix extends FormaPagamento {
    private final String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        System.out.println("Validando Chave Pix: " + chavePix);
        // Validação simples: a chave Pix não pode ser nula ou vazia.
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new PagamentoInvalidoException("Chave Pix inválida.");
        }
    }
}
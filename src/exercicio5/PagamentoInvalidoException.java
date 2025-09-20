package exercicio5;

public class PagamentoInvalidoException extends Exception {

    // Construtor que aceita uma mensagem de erro
    public PagamentoInvalidoException(String mensagem) {
        super(mensagem); // Chama o construtor da classe mãe (Exception)
    }
}
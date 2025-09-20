package exercicio5;

import java.math.BigDecimal;

public abstract class FormaPagamento {

    public abstract void validarPagamento() throws PagamentoInvalidoException;

    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        // 1. Chama o método de validação (que será o da subclasse específica)
        validarPagamento();

        // 2. Se a validação não lançar exceção, o pagamento é considerado processado
        System.out.printf("Pagamento de R$%.2f processado com sucesso usando %s.%n",
                valor, this.getClass().getSimpleName());
    }
}
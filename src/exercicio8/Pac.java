package exercicio8;

import java.math.BigDecimal;

public class Pac implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        System.out.println("Calculando frete via PAC...");
        validarCep(pedido.getCepDestino());
        // Lógica de exemplo: 0.5% do valor do pedido, com um mínimo de R$8.
        BigDecimal frete = pedido.getValorTotal().multiply(new BigDecimal("0.005"));
        return frete.compareTo(new BigDecimal("8.00")) < 0 ? new BigDecimal("8.00") : frete;
    }

    private void validarCep(String cep) {
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new CepInvalidoException("CEP inválido para cálculo via PAC.");
        }
    }
}
package exercicio8;

import java.math.BigDecimal;

public class Sedex implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        System.out.println("Calculando frete via Sedex...");
        validarCep(pedido.getCepDestino());
        // Lógica de exemplo: 1% do valor do pedido, com um mínimo de R$15.
        BigDecimal frete = pedido.getValorTotal().multiply(new BigDecimal("0.01"));
        return frete.compareTo(new BigDecimal("15.00")) < 0 ? new BigDecimal("15.00") : frete;
    }

    private void validarCep(String cep) {
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new CepInvalidoException("CEP inválido para cálculo via Sedex.");
        }
    }
}
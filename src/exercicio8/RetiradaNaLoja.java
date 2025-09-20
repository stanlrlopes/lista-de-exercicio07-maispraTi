package exercicio8;

import java.math.BigDecimal;

public class RetiradaNaLoja implements EstrategiaFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        System.out.println("Calculando frete para Retirada na Loja...");
        return BigDecimal.ZERO; // Custo zero
    }
}
package exercicio8;

import java.math.BigDecimal;

@FunctionalInterface // Anotação opcional, mas boa prática. Garante que a interface só terá um método abstrato.
public interface EstrategiaFrete {
    BigDecimal calcular(Pedido pedido);
}
package exercicio8;

import java.math.BigDecimal;

public class Pedido {
    private final BigDecimal valorTotal;
    private final String cepDestino;

    private EstrategiaFrete estrategiaFrete;

    public Pedido(BigDecimal valorTotal, String cepDestino) {
        this.valorTotal = valorTotal;
        this.cepDestino = cepDestino;
    }

    public BigDecimal getValorTotal() { return valorTotal; }
    public String getCepDestino() { return cepDestino; }

    public void setEstrategiaFrete(EstrategiaFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal calcularFrete() {
        if (estrategiaFrete == null) {
            throw new IllegalStateException("Nenhuma estratégia de frete foi definida.");
        }
        return estrategiaFrete.calcular(this);
    }
}
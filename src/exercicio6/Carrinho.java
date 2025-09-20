package exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal percentualCupom;

    public Carrinho(List<ItemCarrinho> itens, BigDecimal percentualCupom) {
        // 5. Garante que a lista interna seja imutável
        this.itens = List.copyOf(itens);
        this.percentualCupom = percentualCupom;
    }

    public Carrinho() {
        this.itens = Collections.emptyList();
        this.percentualCupom = BigDecimal.ZERO;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Carrinho adicionarItem(Produto produto, int quantidade) {
        List<ItemCarrinho> novosItens = new ArrayList<>(this.itens);
        novosItens.add(new ItemCarrinho(produto, quantidade));
        // Retorna uma NOVA instância de Carrinho
        return new Carrinho(novosItens, this.percentualCupom);
    }

    public Carrinho removerItem(Produto produto) {
        List<ItemCarrinho> novosItens = this.itens.stream()
                .filter(item -> !item.getProduto().equals(produto))
                .toList();
        // Retorna uma NOVA instância de Carrinho
        return new Carrinho(novosItens, this.percentualCupom);
    }

    public Carrinho aplicarCupom(BigDecimal percentual) {
        if (percentual.compareTo(new BigDecimal("0.30")) > 0 || percentual.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cupom deve ser entre 0% e 30%.");
        }
        // Retorna uma NOVA instância de Carrinho com o cupom aplicado
        return new Carrinho(this.itens, percentual);
    }

    public Dinheiro getTotal() {
        Dinheiro total = new Dinheiro(BigDecimal.ZERO, Moeda.BRL);
        for (ItemCarrinho item : this.itens) {
            total = total.adicionar(item.getSubtotal());
        }

        if (percentualCupom.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal fatorDesconto = BigDecimal.ONE.subtract(percentualCupom);
            BigDecimal valorComDesconto = total.getValor().multiply(fatorDesconto)
                    .setScale(2, RoundingMode.HALF_EVEN); // Arredondamento bancário
            total = new Dinheiro(valorComDesconto, total.getMoeda());
        }

        return total;
    }

    @Override
    public String toString() {
        return "Carrinho [itens=" + itens.size() + ", cupom=" + percentualCupom.multiply(BigDecimal.valueOf(100)) + "%, total=" + getTotal() + "]";
    }
}
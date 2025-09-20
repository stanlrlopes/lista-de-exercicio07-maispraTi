package exercicio6;

public final class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Dinheiro getSubtotal() {
        return produto.getPreco().multiplicar(this.quantidade);
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }

    @Override
    public String toString() {
        return String.format("%s (Qtd: %d, Subtotal: %s)", produto.getNome(), quantidade, getSubtotal());
    }
}
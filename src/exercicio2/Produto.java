package exercicio2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {
    private String nome;
    private BigDecimal preco;
    private int quantidadeEmEstoque;

    public String getNome() {
        return this.nome;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public int getQuantidadeEmEstoque() {
        return this.quantidadeEmEstoque;
    }

    public void setNome(String nome) {
        // Validação: verifica se o nome é nulo ou está em branco.
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        // Validação: usando o método compareTo do BigDecimal.
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        // Validação: verifica se a quantidade é menor que zero.
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 50) {
            throw new IllegalArgumentException("A porcentagem de desconto deve ser entre 0 e 50.");
        }

        BigDecimal fatorDesconto = BigDecimal.valueOf(porcentagem / 100.0);

        BigDecimal valorDoDesconto = this.preco.multiply(fatorDesconto);

        this.setPreco(this.preco.subtract(valorDoDesconto));
    }
}

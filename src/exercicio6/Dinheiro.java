package exercicio6;

import java.math.BigDecimal;
import java.util.Objects;

// 1. Classe é 'final'
public final class Dinheiro {
    // 2. Atributos são 'private' e 'final'
    private final BigDecimal valor;
    private final Moeda moeda;

    // 3. Atributos inicializados no construtor
    public Dinheiro(BigDecimal valor, Moeda moeda) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor não pode ser nulo ou negativo.");
        }
        this.valor = valor;
        this.moeda = moeda;
    }

    // Não há setters!

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    // Métodos que fazem operações retornam NOVAS instâncias
    public Dinheiro adicionar(Dinheiro outro) {
        if (this.moeda != outro.moeda) {
            throw new IllegalArgumentException("Não é possível somar valores de moedas diferentes.");
        }
        return new Dinheiro(this.valor.add(outro.valor), this.moeda);
    }

    public Dinheiro multiplicar(int quantidade) {
        return new Dinheiro(this.valor.multiply(BigDecimal.valueOf(quantidade)), this.moeda);
    }

    // 4. equals() e hashCode() sobrescritos para comparar por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return valor.equals(dinheiro.valor) && moeda == dinheiro.moeda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moeda);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", moeda, valor);
    }
}
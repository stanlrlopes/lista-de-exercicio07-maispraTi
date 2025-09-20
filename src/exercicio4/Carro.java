package exercicio4;

public class Carro implements IMeioTransporte {

    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 180;
    private static final int INCREMENTO_VELOCIDADE = 10;

    @Override
    public void acelerar() {
        if (velocidadeAtual + INCREMENTO_VELOCIDADE <= VELOCIDADE_MAXIMA) {
            velocidadeAtual += INCREMENTO_VELOCIDADE;
            System.out.println("Carro acelerando. Velocidade atual: " + velocidadeAtual + " km/h");
        } else {
            velocidadeAtual = VELOCIDADE_MAXIMA;
            System.out.println("Carro já está na velocidade máxima!");
        }
    }

    @Override
    public void frear() {
        if (velocidadeAtual > 0) {
            velocidadeAtual -= INCREMENTO_VELOCIDADE;
            System.out.println("Carro freando. Velocidade atual: " + velocidadeAtual + " km/h");
        } else {
            throw new IllegalStateException("O carro já está parado, não é possível frear.");
        }
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }
}
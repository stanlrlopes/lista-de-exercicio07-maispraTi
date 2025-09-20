package exercicio4;

public class Trem implements IMeioTransporte {

    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 250;
    private static final int INCREMENTO_VELOCIDADE = 20;

    @Override
    public void acelerar() {
        if (velocidadeAtual < VELOCIDADE_MAXIMA) {
            velocidadeAtual += INCREMENTO_VELOCIDADE;
            System.out.println("Trem aumentando a potência. Velocidade: " + velocidadeAtual + " km/h");
        } else {
            System.out.println("Trem já está na velocidade máxima de cruzeiro!");
        }
    }

    @Override
    public void frear() {
        if (velocidadeAtual > 0) {
            velocidadeAtual -= INCREMENTO_VELOCIDADE;
            System.out.println("Trem acionando os freios. Velocidade: " + velocidadeAtual + " km/h");
        } else {
            System.out.println("Trem já está parado na estação.");
        }
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }
}
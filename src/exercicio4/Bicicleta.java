package exercicio4;

public class Bicicleta implements IMeioTransporte {

    private int velocidadeAtual = 0;
    private static final int VELOCIDADE_MAXIMA = 30;
    private static final int INCREMENTO_VELOCIDADE = 2;

    @Override
    public void acelerar() {
        if (velocidadeAtual < VELOCIDADE_MAXIMA) {
            velocidadeAtual += INCREMENTO_VELOCIDADE;
            System.out.println("Bicicleta pedalando mais rápido. Velocidade: " + velocidadeAtual + " km/h");
        } else {
            System.out.println("Bicicleta já está na velocidade máxima!");
        }
    }

    @Override
    public void frear() {
        if (velocidadeAtual > 0) {
            velocidadeAtual -= INCREMENTO_VELOCIDADE;
            System.out.println("Bicicleta freando. Velocidade: " + velocidadeAtual + " km/h");
        } else {
            System.out.println("Bicicleta já está parada.");
        }
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }
}
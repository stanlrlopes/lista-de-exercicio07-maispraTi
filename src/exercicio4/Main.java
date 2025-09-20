package exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Criando uma lista do tipo da INTERFACE
        List<IMeioTransporte> veiculos = new ArrayList<>();

        // 2. Adicionando objetos de classes diferentes que implementam a mesma interface
        veiculos.add(new Carro());
        veiculos.add(new Bicicleta());
        veiculos.add(new Trem());

        // 3. Demonstrando o polimorfismo
        for (IMeioTransporte veiculo : veiculos) {
            // O '.getClass().getSimpleName()' pega o nome da classe do objeto (Carro, Bicicleta, etc.)
            System.out.println("\n--- Testando o " + veiculo.getClass().getSimpleName() + " ---");

            veiculo.acelerar(); // Chama o acelerar() específico de cada objeto
            veiculo.acelerar();
            veiculo.frear();    // Chama o frear() específico de cada objeto
        }

        System.out.println("\n--- Testando Operação Inválida com Exceção ---");
        // Criando um carro e tentando frear quando ele já está parado
        Carro meuCarro = new Carro();
        System.out.println("Velocidade inicial do carro: " + meuCarro.getVelocidadeAtual() + " km/h");
        try {
            System.out.println("Tentando frear o carro parado...");
            meuCarro.frear();
        } catch (IllegalStateException e) {
            System.out.println("ERRO CAPTURADO: " + e.getMessage());
        }
    }
}
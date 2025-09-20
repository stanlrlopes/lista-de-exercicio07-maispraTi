# Atividade 7 - Programação Orientada a Objetos com Java

Este repositório contém a resolução da Lista de Exercícios 7, referente ao módulo de Programação Orientada a Objetos (Java OO) do curso **Desenvolvedor Full Stack Júnior**.

Uma parceria educacional entre **+praTi** e **Codifica**.

Desenvolvido por: **Stanlr Lopes**

---

## ☕ Conceitos Abordados

Cada exercício foi projetado para explorar um pilar ou conceito fundamental da Programação Orientada a Objetos, resultando em um projeto que serve como um guia prático dos seguintes tópicos:

* **Exercício 1:** Encapsulamento (proteção de dados com getters, setters e validações).
* **Exercício 2:** Encapsulamento com Regras de Negócio (adição de comportamentos com validações).
* **Exercício 3:** Herança e Polimorfismo (criação de hierarquias de classes com `extends`).
* **Exercício 4:** Polimorfismo com Interfaces (definição de contratos de comportamento com `implements`).
* **Exercício 5:** Abstração (uso de classes abstratas para definir modelos e fluxos de trabalho).
* **Exercício 6:** Imutabilidade e Objetos de Valor (criação de objetos seguros, previsíveis e com valor semântico).
* **Exercício 7:** Generics (desenvolvimento de código reutilizável e com segurança de tipo, como o Repositório Genérico).
* **Exercício 8:** Padrão de Projeto Strategy e Lambdas (implementação de algoritmos intercambiáveis de forma moderna e flexível).

---

## 🛠️ Pré-requisitos

Para compilar e executar este projeto, você precisará de:

* Java Development Kit (JDK) 17 ou superior.
* Uma IDE Java, como IntelliJ IDEA (recomendado), Eclipse ou VS Code com o Java Extension Pack.

---

## 📁 Estrutura do Projeto

O código-fonte está organizado em pacotes, onde cada pacote corresponde a um exercício da lista. Isso mantém o código de cada desafio isolado e fácil de localizar.

```
lista-de-exercicio07-maispraTi/
├── .gitignore
├── README.md
└── src/
    ├── exercicio1/
    │   ├── Main.java
    │   └── Produto.java
    ├── exercicio2/
    │   ├── Main.java
    │   └── Produto.java
     ├── exercicio3/
    │   ├── Desenvolvedor.java
    │   ├── Funcionario.java
    │   ├── Gerente.java
    │   └── Main.java
    │
    ├── exercicio4/
    │   ├── Bicicleta.java
    │   ├── Carro.java
    │   ├── IMeioTransporte.java
    │   ├── Main.java
    │   └── Trem.java
    │
    ├── exercicio5/
    │   ├── Boleto.java
    │   ├── CartaoCredito.java
    │   ├── FormaPagamento.java
    │   ├── Main.java
    │   ├── PagamentoInvalidoException.java
    │   └── Pix.java
    │
    ├── exercicio6/
    │   ├── Carrinho.java
    │   ├── Dinheiro.java
    │   ├── ItemCarrinho.java
    │   ├── Main.java
    │   ├── Moeda.java
    │   └── Produto.java
    │
    ├── exercicio7/
    │   ├── Cliente.java
    │   ├── EntidadeNaoEncontradaException.java
    │   ├── Identificavel.java
    │   ├── IRepository.java
    │   ├── InMemoryRepository.java
    │   ├── Main.java
    │   └── Produto.java
    │
    └── exercicio8/
        ├── CepInvalidoException.java
        ├── EstrategiaFrete.java
        ├── Main.java
        ├── Pac.java
        ├── Pedido.java
        ├── RetiradaNaLoja.java
        └── Sedex.java
```

---

## ▶️ Como Executar

Cada exercício possui sua própria classe `Main.java` e pode ser executado de forma independente.

### 1. Pela IDE (Recomendado)

Esta é a forma mais simples de executar os exercícios:

1.  Clone este repositório para a sua máquina local:
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    ```
2.  Abra o projeto na sua IDE (ex: IntelliJ IDEA).
3.  Navegue pela estrutura de pastas no painel "Project" até o pacote do exercício desejado (ex: `src/exercicio1`).
4.  Abra o arquivo `Main.java` correspondente.
5.  Clique com o botão direito no editor de código e selecione a opção **"Run 'Main.main()'"** ou utilize o atalho correspondente (normalmente um ícone de "play" verde ao lado da declaração do método `main`).

### 2. Pelo Terminal (Avançado)

Se você tiver o JDK configurado corretamente no PATH do seu sistema, pode compilar e executar cada exercício via linha de comando.

1.  Abra o terminal e navegue até a pasta `src` do projeto.
2.  **Compile** os arquivos `.java` do exercício desejado. Você precisa compilar todas as classes que o `Main` utiliza.
    ```bash
    # Exemplo para o Exercício 3
    javac exercicio3/Main.java exercicio3/Funcionario.java exercicio3/Gerente.java exercicio3/Desenvolvedor.java
    ```
3.  **Execute** a classe `Main` especificando o nome completo (pacote.Classe).
    ```bash
    # Exemplo para o Exercício 3
    java exercicio3.Main
    ```
4.  Adapte os comandos acima para o pacote do exercício que deseja executar.

---

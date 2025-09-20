package exercicio7;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // 1. Criando um repositório PARA PRODUTOS
        IRepository<Produto, Long> repoProdutos = new InMemoryRepository<>();

        System.out.println("--- Gerenciando Produtos ---");
        repoProdutos.salvar(new Produto(1L, "Notebook"));
        repoProdutos.salvar(new Produto(2L, "Mouse"));

        System.out.println("Todos os produtos: " + repoProdutos.listarTodos());

        // 2. Buscando um produto que existe
        Optional<Produto> produtoEncontrado = repoProdutos.buscarPorId(1L);
        produtoEncontrado.ifPresent(p -> System.out.println("Produto encontrado: " + p));

        // 3. Removendo e listando novamente
        repoProdutos.remover(2L);
        System.out.println("Produtos após remover o ID 2: " + repoProdutos.listarTodos());

        System.out.println("\n--- Gerenciando Clientes ---");
        // 4. A MESMA implementação de repositório, agora PARA CLIENTES
        IRepository<Cliente, Integer> repoClientes = new InMemoryRepository<>();
        repoClientes.salvar(new Cliente(101, "Ana"));
        repoClientes.salvar(new Cliente(102, "Carlos"));

        System.out.println("Todos os clientes: " + repoClientes.listarTodos());

        // 5. Buscando um cliente que NÃO existe
        Optional<Cliente> clienteInexistente = repoClientes.buscarPorId(999);
        if (clienteInexistente.isEmpty()) {
            System.out.println("Cliente com ID 999 não foi encontrado (Optional está vazio).");
        }

        // 6. Tentando remover um cliente que não existe
        try {
            System.out.println("Tentando remover cliente com ID 999...");
            repoClientes.remover(999);
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("ERRO CAPTURADO: " + e.getMessage());
        }
    }
}
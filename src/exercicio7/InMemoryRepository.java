package exercicio7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryRepository<T extends Identificavel<ID>, ID> implements IRepository<T, ID> {

    private final Map<ID, T> armazenamento = new HashMap<>();

    @Override
    public void salvar(T entidade) {
        armazenamento.put(entidade.getId(), entidade);
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(armazenamento.get(id));
    }

    @Override
    public List<T> listarTodos() {
        return List.copyOf(armazenamento.values());
    }

    @Override
    public void remover(ID id) throws EntidadeNaoEncontradaException {
        if (!armazenamento.containsKey(id)) {
            throw new EntidadeNaoEncontradaException("Entidade com ID " + id + " não encontrada.");
        }
        armazenamento.remove(id);
    }
}
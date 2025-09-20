package exercicio7;

public class Cliente implements Identificavel<Integer> {
    private final Integer id;
    private final String nome;

    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Cliente[ID=" + id + ", Nome='" + nome + "']";
    }
}
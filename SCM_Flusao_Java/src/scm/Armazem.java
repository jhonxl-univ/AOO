package scm;

public class Armazem {
    private final String nome;
    private final String endereco;
    private final int capacidade;
    private final Cidade cidade;

    public Armazem(String nome, String endereco, int capacidade, Cidade cidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.capacidade = capacidade;
        this.cidade = cidade;
    }

    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public int getCapacidade() { return capacidade; }
    public Cidade getCidade() { return cidade; }
}

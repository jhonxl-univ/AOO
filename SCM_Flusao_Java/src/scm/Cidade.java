package scm;

public class Cidade {
    private final String nome;
    private final Pais pais;

    public Cidade(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
        pais.adicionarCidade(this);
    }

    public String getNome() { return nome; }
    public Pais getPais() { return pais; }
}

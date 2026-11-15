package scm;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private final int id;
    private final String nome;
    private final List<Cidade> cidades = new ArrayList<>();

    public Pais(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void adicionarCidade(Cidade cidade) { cidades.add(cidade); }
    public int getId() { return id; }
    public String getNome() { return nome; }
    public List<Cidade> getCidades() { return cidades; }
}

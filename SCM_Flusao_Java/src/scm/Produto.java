package scm;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private final int id;
    private final String nome;
    private final String descricao;
    private final Cidade cidadeOrigem;
    private final List<Item> itens = new ArrayList<>();
    private SituacaoProduto situacao = SituacaoProduto.ATIVO; // estado inicial após cadastrar

    public Produto(int id, String nome, String descricao, Cidade cidadeOrigem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cidadeOrigem = cidadeOrigem;
    }

    public void adicionarItem(Item item) { itens.add(item); }

    // Transições do diagrama de estado do Produto
    public void movimentar() {
        exigir(SituacaoProduto.ATIVO, "movimentar");
        situacao = SituacaoProduto.EM_TRANSITO;
    }

    public void suspender() {
        exigir(SituacaoProduto.EM_TRANSITO, "suspender");
        situacao = SituacaoProduto.SUSPENSO;
    }

    public void retomar() {
        exigir(SituacaoProduto.SUSPENSO, "retomar");
        situacao = SituacaoProduto.EM_TRANSITO;
    }

    public void finalizar() {
        exigir(SituacaoProduto.EM_TRANSITO, "finalizar");
        situacao = SituacaoProduto.FINALIZADO;
    }

    private void exigir(SituacaoProduto esperado, String acao) {
        if (situacao != esperado) {
            throw new IllegalStateException("Não é possível " + acao + " um produto " + situacao);
        }
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public Cidade getCidadeOrigem() { return cidadeOrigem; }
    public List<Item> getItens() { return itens; }
    public SituacaoProduto getSituacao() { return situacao; }
}

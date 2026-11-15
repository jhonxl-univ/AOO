package scm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Corresponde à classe "Transportadora" do diagrama conceitual (movimentação entre armazéns). */
public class Transporte {
    private final Armazem origem;
    private final Armazem destino;
    private final EmpresaParceira empresa;
    private final Agente agente;
    private final LocalDate dataInicio;
    private final List<Produto> produtos = new ArrayList<>();
    private SituacaoTransporte situacao = SituacaoTransporte.PLANEJADO;

    public Transporte(Armazem origem, Armazem destino, EmpresaParceira empresa,
                      Agente agente, LocalDate dataInicio) {
        this.origem = origem;
        this.destino = destino;
        this.empresa = empresa;
        this.agente = agente;
        this.dataInicio = dataInicio;
    }

    public void adicionarProduto(Produto p) { produtos.add(p); }

    public void iniciar() {
        if (situacao != SituacaoTransporte.PLANEJADO)
            throw new IllegalStateException("Só é possível iniciar transporte PLANEJADO");
        situacao = SituacaoTransporte.EM_TRANSITO;
        produtos.forEach(Produto::movimentar);
    }

    public void entregar() {
        if (situacao != SituacaoTransporte.EM_TRANSITO)
            throw new IllegalStateException("Só é possível entregar transporte EM_TRANSITO");
        situacao = SituacaoTransporte.ENTREGUE;
        produtos.forEach(Produto::finalizar);
    }

    public void cancelar() {
        if (situacao != SituacaoTransporte.EM_TRANSITO)
            throw new IllegalStateException("Só é possível cancelar transporte EM_TRANSITO");
        situacao = SituacaoTransporte.CANCELADO;
    }

    public Armazem getOrigem() { return origem; }
    public Armazem getDestino() { return destino; }
    public EmpresaParceira getEmpresa() { return empresa; }
    public Agente getAgente() { return agente; }
    public LocalDate getDataInicio() { return dataInicio; }
    public List<Produto> getProdutos() { return produtos; }
    public SituacaoTransporte getSituacao() { return situacao; }
}

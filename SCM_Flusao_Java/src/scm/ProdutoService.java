package scm;

import java.util.ArrayList;
import java.util.List;

/** Caso de uso: Cadastrar Produto (ator: Departamento de Materiais). */
public class ProdutoService {
    private final List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    public Produto cadastrarProduto(String nome, String descricao, Cidade cidadeFabricacao,
                                    List<Item> itens) {
        // Pré-condição: cidade de fabricação cadastrada
        if (cidadeFabricacao == null)
            throw new IllegalArgumentException("Cidade de fabricação é obrigatória");
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome do produto é obrigatório");
        if (itens == null || itens.isEmpty())
            throw new IllegalArgumentException("O produto deve ter ao menos um item");

        Produto produto = new Produto(proximoId++, nome, descricao, cidadeFabricacao);
        itens.forEach(produto::adicionarItem);
        produtos.add(produto);
        return produto;
    }

    public List<Produto> listar() { return produtos; }
}

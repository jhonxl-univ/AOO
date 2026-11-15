package scm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Caso de uso: Cadastrar Transporte (ator: Departamento de Logística). */
public class TransporteService {
    private final List<Transporte> transportes = new ArrayList<>();

    public Transporte cadastrarTransporte(Armazem origem, Armazem destino,
                                          EmpresaParceira empresa, Agente agente,
                                          List<Produto> produtos) {
        // Pré-condições: armazéns, empresa parceira e agente cadastrados
        if (origem == null || destino == null)
            throw new IllegalArgumentException("Armazéns de origem e destino são obrigatórios");
        if (origem == destino)
            throw new IllegalArgumentException("Origem e destino devem ser diferentes");
        if (empresa == null || agente == null)
            throw new IllegalArgumentException("Empresa parceira e agente são obrigatórios");
        if (produtos == null || produtos.isEmpty())
            throw new IllegalArgumentException("Informe ao menos um produto");

        Transporte t = new Transporte(origem, destino, empresa, agente, LocalDate.now());
        produtos.forEach(t::adicionarProduto);
        transportes.add(t);
        return t;
    }

    public List<Transporte> listar() { return transportes; }
}

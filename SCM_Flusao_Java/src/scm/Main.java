package scm;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pais brasil = new Pais(1, "Brasil");
        Pais china = new Pais(2, "China");
        Cidade niteroi = new Cidade("Niterói", brasil);
        Cidade xangai = new Cidade("Xangai", china);

        Armazem arm1 = new Armazem("Armazém Niterói", "Av. Principal, 100", 5000, niteroi);
        Armazem arm2 = new Armazem("Armazém Xangai", "Pudong Rd, 200", 8000, xangai);

        EmpresaParceira empresa = new EmpresaParceira("LogiMar", "12.345.678/0001-90", "contato@logimar.com");
        Agente agente = new Agente("Carlos Silva", "21 99999-0000", "carlos@logimar.com", empresa);

        // Cadastrar Produto
        ProdutoService produtoService = new ProdutoService();
        Produto notebook = produtoService.cadastrarProduto(
                "Notebook", "Notebook 15 polegadas", niteroi,
                List.of(new Item(1, "Placa-mãe", "Placa-mãe ATX"),
                        new Item(2, "Tela", "Tela LED 15\"")));
        System.out.println("Produto cadastrado: " + notebook.getNome()
                + " [" + notebook.getSituacao() + "]");

        // Cadastrar Transporte
        TransporteService transporteService = new TransporteService();
        Transporte t = transporteService.cadastrarTransporte(
                arm1, arm2, empresa, agente, List.of(notebook));
        System.out.println("Transporte: " + t.getOrigem().getNome() + " -> "
                + t.getDestino().getNome() + " [" + t.getSituacao() + "]");

        // Ciclo de vida (diagramas de estado)
        t.iniciar();
        System.out.println("Após iniciar: transporte " + t.getSituacao()
                + ", produto " + notebook.getSituacao());
        t.entregar();
        System.out.println("Após entregar: transporte " + t.getSituacao()
                + ", produto " + notebook.getSituacao());

        // Validação: cadastro sem cidade deve falhar
        try {
            produtoService.cadastrarProduto("Mouse", "Mouse USB", null, List.of());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}

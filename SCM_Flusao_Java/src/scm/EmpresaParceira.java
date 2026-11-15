package scm;

public class EmpresaParceira {
    private final String nome;
    private final String cnpj;
    private final String contato;

    public EmpresaParceira(String nome, String cnpj, String contato) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
    }

    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }
    public String getContato() { return contato; }
}

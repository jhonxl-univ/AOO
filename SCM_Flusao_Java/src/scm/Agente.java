package scm;

public class Agente {
    private final String nome;
    private final String telefone;
    private final String email;
    private final EmpresaParceira empresa;

    public Agente(String nome, String telefone, String email, EmpresaParceira empresa) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.empresa = empresa;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public EmpresaParceira getEmpresa() { return empresa; }
}

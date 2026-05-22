package br.com.nexora.entities;

public class Voluntario {
    private int id;
    private String nome;
    private long cpf;
    private String cro;
    private String telefone;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Voluntario() {
    }

    public Voluntario(int id, String nome, long cpf, String cro, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cro = cro;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Voluntario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", cro='" + cro + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

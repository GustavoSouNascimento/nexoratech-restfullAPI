package br.com.nexora.entities;

public class Triagem {
    private int id;
    private int paciente;
    private int usuario;
    private String descricao;
    private String urgencia;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaciente() {
        return paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Triagem() {
    }

    public Triagem(int id, int paciente, int usuario, String descricao, String urgencia, String status) {
        this.id = id;
        this.paciente = paciente;
        this.usuario = usuario;
        this.descricao = descricao;
        this.urgencia = urgencia;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Triagem{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", usuario=" + usuario +
                ", descricao='" + descricao + '\'' +
                ", urgencia='" + urgencia + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

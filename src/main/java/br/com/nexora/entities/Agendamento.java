package br.com.nexora.entities;

public class Agendamento {
    private int id;
    private int paciente;
    private int voluntario;
    private int tratamento;
    private String dataHora;
    private String local;
    private String status;
    private String observacao;

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

    public int getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(int voluntario) {
        this.voluntario = voluntario;
    }

    public int getTratamento() {
        return tratamento;
    }

    public void setTratamento(int tratamento) {
        this.tratamento = tratamento;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Agendamento() {
    }

    public Agendamento(int id, int paciente, int voluntario, int tratamento, String dataHora, String local, String status) {
        this.id = id;
        this.paciente = paciente;
        this.voluntario = voluntario;
        this.tratamento = tratamento;
        this.dataHora = dataHora;
        this.local = local;
        this.status = status;
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", voluntario=" + voluntario +
                ", tratamento=" + tratamento +
                ", dataHora='" + dataHora + '\'' +
                ", local='" + local + '\'' +
                ", status='" + status + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}

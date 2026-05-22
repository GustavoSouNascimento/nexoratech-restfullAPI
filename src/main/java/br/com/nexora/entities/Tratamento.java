package br.com.nexora.entities;

public class Tratamento {
    private int id;
    private int paciente;
    private int voluntario;
    private String dataInicio;
    private String dataConclusao;
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

    public int getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(int voluntario) {
        this.voluntario = voluntario;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tratamento() {
    }

    public Tratamento(int id, int paciente, int voluntario, String dataInicio, String dataConclusao, String status) {
        this.id = id;
        this.paciente = paciente;
        this.voluntario = voluntario;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tratamento{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", voluntario=" + voluntario +
                ", dataInicio='" + dataInicio + '\'' +
                ", dataConclusao='" + dataConclusao + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

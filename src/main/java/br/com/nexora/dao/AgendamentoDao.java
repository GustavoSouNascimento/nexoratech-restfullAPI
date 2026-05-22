package br.com.nexora.dao;

import br.com.nexora.conexoes.ConexaoFactory;
import br.com.nexora.entities.Agendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDao {
    public Connection minhaConexao;

    public AgendamentoDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Agendamento agendamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into AGENDAMENTO values (?,?,?,?,?,?,?,?)");
        stmt.setInt(1, agendamento.getId());
        stmt.setInt(2, agendamento.getVoluntario());
        stmt.setInt(3, agendamento.getTratamento());
        stmt.setInt(4, agendamento.getPaciente());
        stmt.setString(5, agendamento.getDataHora());
        stmt.setString(6, agendamento.getLocal());
        stmt.setString(7, agendamento.getStatus());
        stmt.setString(8, agendamento.getObservacao());

        stmt.execute();
        stmt.close();

        return "Informações inseridas com sucesso.";
    }

    public List<Agendamento> selecionar() throws SQLException {
        List<Agendamento> listaAgendamentos = new ArrayList<Agendamento>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from AGENDAMENTO");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Agendamento agendamento = new Agendamento();
            agendamento.setId(rs.getInt(1));
            agendamento.setVoluntario(rs.getInt(2));
            agendamento.setTratamento(rs.getInt(3));
            agendamento.setPaciente(rs.getInt(4));
            agendamento.setDataHora(rs.getString(5));
            agendamento.setLocal(rs.getString(6));
            agendamento.setStatus(rs.getString(7));
            agendamento.setObservacao(rs.getString(8));
            listaAgendamentos.add(agendamento);
        }
        return listaAgendamentos;
    }

    public Agendamento buscarId(int id) throws SQLException {
        Agendamento agendamento = null;

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM AGENDAMENTO WHERE id_agenda = ?");
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            agendamento = new Agendamento();
            agendamento.setId(rs.getInt(1));
            agendamento.setVoluntario(rs.getInt(2));
            agendamento.setTratamento(rs.getInt(3));
            agendamento.setPaciente(rs.getInt(4));
            agendamento.setDataHora(rs.getString(5));
            agendamento.setLocal(rs.getString(6));
            agendamento.setStatus(rs.getString(7));
            agendamento.setObservacao(rs.getString(8));
        }

        rs.close();
        stmt.close();

        return agendamento;
    }

    public String atualizar(Agendamento agendamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Update AGENDAMENTO set voluntario_id_volun = ?, tratamento_id_trata = ?, paciente_id_paci = ?, data_agenda = ?, local_agenda = ?, status_agenda = ?, observa_agenda = ? where id_agenda = ?");
        stmt.setInt(1, agendamento.getVoluntario());
        stmt.setInt(2, agendamento.getTratamento());
        stmt.setInt(3, agendamento.getPaciente());
        stmt.setString(4, agendamento.getDataHora());
        stmt.setString(5, agendamento.getLocal());
        stmt.setString(6, agendamento.getStatus());
        stmt.setString(7, agendamento.getObservacao());
        stmt.setInt(8, agendamento.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Agendamento atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete from AGENDAMENTO where id_agenda = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return  "Agendamento deletado com sucesso!";
    }
}

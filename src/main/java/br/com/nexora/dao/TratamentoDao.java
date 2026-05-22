package br.com.nexora.dao;

import br.com.nexora.conexoes.ConexaoFactory;
import br.com.nexora.entities.Tratamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TratamentoDao {
    public Connection minhaConexao;

    public TratamentoDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Tratamento tratamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into TRATAMENTO values (?,?,?,?,?,?)");
        stmt.setInt(1, tratamento.getId());
        stmt.setInt(2, tratamento.getVoluntario());
        stmt.setInt(3, tratamento.getPaciente());
        stmt.setString(4, tratamento.getDataInicio());
        stmt.setString(5, tratamento.getDataConclusao());
        stmt.setString(6, tratamento.getStatus());

        stmt.execute();
        stmt.close();

        return "Informações inseridas com sucesso.";
    }

    public List<Tratamento> selecionar() throws SQLException {
        List<Tratamento> listaTratamentos = new ArrayList<Tratamento>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from TRATAMENTO");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Tratamento tratamento = new Tratamento();
            tratamento.setId(rs.getInt(1));
            tratamento.setVoluntario(rs.getInt(2));
            tratamento.setPaciente(rs.getInt(3));
            tratamento.setDataInicio(rs.getString(4));
            tratamento.setDataConclusao(rs.getString(5));
            tratamento.setStatus(rs.getString(6));
            listaTratamentos.add(tratamento);
        }
        return listaTratamentos;
    }

    public Tratamento buscarId(int id) throws SQLException {
        Tratamento tratamento = null;

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM TRATAMENTO WHERE id_trata = ?");
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            tratamento = new Tratamento();
            tratamento.setId(rs.getInt(1));
            tratamento.setVoluntario(rs.getInt(2));
            tratamento.setPaciente(rs.getInt(3));
            tratamento.setDataInicio(rs.getString(4));
            tratamento.setDataConclusao(rs.getString(5));
            tratamento.setStatus(rs.getString(6));
        }

        rs.close();
        stmt.close();

        return tratamento;
    }

    public String atualizar(Tratamento tratamento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Update TRATAMENTO set voluntario_id_volun = ?, paciente_id_paci = ?, dtiniciotrata = ?, dtconclusao_trata = ?, status_trata = ? where id_trata = ?");
        stmt.setInt(1, tratamento.getVoluntario());
        stmt.setInt(2, tratamento.getPaciente());
        stmt.setString(3, tratamento.getDataInicio());
        stmt.setString(4, tratamento.getDataConclusao());
        stmt.setString(5, tratamento.getStatus());
        stmt.setInt(6, tratamento.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Tratamento atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete from TRATAMENTO where id_trata = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return  "Tratamento deletado com sucesso!";
    }
}

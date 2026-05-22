package br.com.nexora.dao;

import br.com.nexora.conexoes.ConexaoFactory;
import br.com.nexora.entities.Paciente;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {
    public Connection minhaConexao;

    public PacienteDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into PACIENTE values (?,?,?,?,?,?,?,?)");
        stmt.setInt(1, paciente.getId());
        stmt.setString(2, paciente.getNome());
        stmt.setLong(3, paciente.getCpf());
        stmt.setString(4, paciente.getDataNascimento());
        stmt.setString(5, paciente.getTelefone());
        stmt.setString(6, paciente.getEmail());
        stmt.setString(7, paciente.getEndereco());
        stmt.setString(8, paciente.getStatus());

        stmt.execute();
        stmt.close();
        minhaConexao.close();

        return "Paciente inserido com sucesso.";
    }

    public List<Paciente> selecionar() throws SQLException {
        List<Paciente> listaPacientes = new ArrayList<Paciente>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from PACIENTE");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Paciente paciente = new Paciente();
            paciente.setId(rs.getInt(1));
            paciente.setNome(rs.getString(2));
            paciente.setCpf(rs.getLong(3));
            paciente.setDataNascimento(rs.getString(4));
            paciente.setTelefone(rs.getString(5));
            paciente.setEmail(rs.getString(6));
            paciente.setEndereco(rs.getString(7));
            paciente.setStatus(rs.getString(8));
            listaPacientes.add(paciente);
        }
        minhaConexao.close();
        return listaPacientes;
    }

    public Paciente buscarId(int id) throws SQLException {
        Paciente paciente = null;

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM PACIENTE WHERE id_paci = ?");
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            paciente = new Paciente();
            paciente.setId(rs.getInt(1));
            paciente.setNome(rs.getString(2));
            paciente.setCpf(rs.getLong(3));
            paciente.setDataNascimento(rs.getString(4));
            paciente.setTelefone(rs.getString(5));
            paciente.setEmail(rs.getString(6));
            paciente.setEndereco(rs.getString(7));
            paciente.setStatus(rs.getString(8));
        }

        rs.close();
        stmt.close();
        minhaConexao.close();

        return paciente;
    }

    public String atualizar(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Update PACIENTE set nm_paci = ?, cpf_paci = ?, dtnasc_paci = ?, telefone_paci = ?, email_paci = ?, end_paci = ?, status_paci = ? where id_paci = ?");
        stmt.setString(1, paciente.getNome());
        stmt.setLong(2, paciente.getCpf());
        stmt.setString(3, paciente.getDataNascimento());
        stmt.setString(4, paciente.getTelefone());
        stmt.setString(5, paciente.getEmail());
        stmt.setString(6, paciente.getEndereco());
        stmt.setString(7, paciente.getStatus());
        stmt.setInt(8, paciente.getId());

        stmt.executeUpdate();
        stmt.close();
        minhaConexao.close();

        return "Paciente atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete from PACIENTE where id_paci = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();
        minhaConexao.close();

        return  "Paciente deletado com sucesso!";
    }
}
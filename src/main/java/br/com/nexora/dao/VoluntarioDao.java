package br.com.nexora.dao;

import br.com.nexora.conexoes.ConexaoFactory;
import br.com.nexora.entities.Voluntario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoluntarioDao {
    public Connection minhaConexao;

    public VoluntarioDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Voluntario voluntario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into VOLUNTARIO values (?,?,?,?,?,?)");
        stmt.setInt(1, voluntario.getId());
        stmt.setString(2, voluntario.getNome());
        stmt.setLong(3, voluntario.getCpf());
        stmt.setString(4, voluntario.getCro());
        stmt.setString(5, voluntario.getTelefone());
        stmt.setString(6, voluntario.getEmail());

        stmt.execute();
        stmt.close();

        return "Voluntário inserido com sucesso.";
    }

    public List<Voluntario> selecionar() throws SQLException {
        List<Voluntario> listaVoluntarios = new ArrayList<Voluntario>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from VOLUNTARIO");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Voluntario voluntario = new Voluntario();
            voluntario.setId(rs.getInt(1));
            voluntario.setNome(rs.getString(2));
            voluntario.setCpf(rs.getLong(3));
            voluntario.setCro(rs.getString(4));
            voluntario.setTelefone(rs.getString(5));
            voluntario.setEmail(rs.getString(6));
            listaVoluntarios.add(voluntario);
        }
        return listaVoluntarios;
    }

    public Voluntario buscarId(int id) throws SQLException {
        Voluntario voluntario = null;

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM VOLUNTARIO WHERE id_volun = ?");
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            voluntario = new Voluntario();
            voluntario.setId(rs.getInt(1));
            voluntario.setNome(rs.getString(2));
            voluntario.setCpf(rs.getLong(3));
            voluntario.setCro(rs.getString(4));
            voluntario.setTelefone(rs.getString(5));
            voluntario.setEmail(rs.getString(6));
        }

        rs.close();
        stmt.close();

        return voluntario;
    }

    public String atualizar(Voluntario voluntario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Update VOLUNTARIO set nm_volun = ?, cpf_volun = ?, cro_volun = ?, telefone_volun = ?, email_volun = ? where id_volun = ?");
        stmt.setString(1, voluntario.getNome());
        stmt.setLong(2, voluntario.getCpf());
        stmt.setString(3, voluntario.getCro());
        stmt.setString(4, voluntario.getTelefone());
        stmt.setString(5, voluntario.getEmail());
        stmt.setInt(6, voluntario.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Voluntario atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete from VOLUNTARIO where id_volun = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return  "Voluntario deletado com sucesso!";
    }
}

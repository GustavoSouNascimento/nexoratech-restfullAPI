package br.com.nexora.dao;

import br.com.nexora.conexoes.ConexaoFactory;
import br.com.nexora.entities.Triagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TriagemDao {
    public Connection minhaConexao;

    public TriagemDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Triagem triagem) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into TRIAGEM values (?,?,?,?,?,?)");
        stmt.setInt(1, triagem.getId());
        stmt.setInt(2, triagem.getPaciente());
        stmt.setInt(3, triagem.getUsuario());
        stmt.setString(4, triagem.getDescricao());
        stmt.setString(5, triagem.getUrgencia());
        stmt.setString(6, triagem.getStatus());

        stmt.execute();
        stmt.close();
        minhaConexao.close();

        return "Triagem inserida com sucesso.";
    }

    public List<Triagem> selecionar() throws SQLException {
        List<Triagem> listaTriagems = new ArrayList<Triagem>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from TRIAGEM");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Triagem triagem = new Triagem();
            triagem.setId(rs.getInt(1));
            triagem.setPaciente(rs.getInt(2));
            triagem.setUsuario(rs.getInt(3));
            triagem.setDescricao(rs.getString(4));
            triagem.setUrgencia(rs.getString(5));
            triagem.setStatus(rs.getString(6));
            listaTriagems.add(triagem);
        }
        minhaConexao.close();
        return listaTriagems;
    }

    public Triagem buscarId(int id) throws SQLException {
        Triagem triagem = null;

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM TRIAGEM WHERE id_tria = ?");
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            triagem = new Triagem();
            triagem.setId(rs.getInt(1));
            triagem.setPaciente(rs.getInt(2));
            triagem.setUsuario(rs.getInt(3));
            triagem.setDescricao(rs.getString(4));
            triagem.setUrgencia(rs.getString(5));
            triagem.setStatus(rs.getString(6));
        }

        rs.close();
        stmt.close();
        minhaConexao.close();

        return triagem;
    }

    public String atualizar(Triagem triagem) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Update TRIAGEM set paciente_id_paci = ?, usuario_admin_id_user = ?, desc_tria = ?, urgencia_tria = ?, status_tria = ? where id_tria = ?");
        stmt.setInt(1, triagem.getPaciente());
        stmt.setInt(2, triagem.getUsuario());
        stmt.setString(3, triagem.getDescricao());
        stmt.setString(4, triagem.getUrgencia());
        stmt.setString(5, triagem.getStatus());
        stmt.setInt(6, triagem.getId());

        stmt.executeUpdate();
        stmt.close();
        minhaConexao.close();

        return "Triagem atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete from TRIAGEM where id_tria = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();
        minhaConexao.close();

        return  "Triagem deletado com sucesso!";
    }
}
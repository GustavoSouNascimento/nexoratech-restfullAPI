package br.com.nexora.dao;

import br.com.nexora.conexoes.ConexaoFactory;
import br.com.nexora.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    public Connection minhaConexao;

    public UsuarioDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into USUARIO_ADMIN values (?,?,?,?,?)");
        stmt.setInt(1, usuario.getId());
        stmt.setString(2, usuario.getNome());
        stmt.setString(3, usuario.getEmail());
        stmt.setString(4, usuario.getPerfil());
        stmt.setString(5, usuario.getSenha());

        stmt.execute();
        stmt.close();

        return "Usuario inserido com sucesso.";
    }

    public List<Usuario> selecionar() throws SQLException {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("select * from USUARIO_ADMIN");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setNome(rs.getString(2));
            usuario.setEmail(rs.getString(3));
            usuario.setPerfil(rs.getString(4));
            usuario.setSenha(rs.getString(5));
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;
    }

    public Usuario buscarId(int id) throws SQLException {
        Usuario usuario = null;

        PreparedStatement stmt = minhaConexao.prepareStatement(
                "SELECT * FROM USUARIO_ADMIN WHERE id_user = ?"
        );
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setNome(rs.getString(2));
            usuario.setEmail(rs.getString(3));
            usuario.setPerfil(rs.getString(4));
            usuario.setSenha(rs.getString(5));
        }

        rs.close();
        stmt.close();

        return usuario;
    }

    public String atualizar(Usuario usuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Update USUARIO_ADMIN set nm_user = ?, email_user = ?, perfil_user = ?, senha_user = ? where id_user = ?");
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getPerfil());
        stmt.setString(4, usuario.getSenha());
        stmt.setInt(5, usuario.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Usuario atualizado com sucesso!";
    }

    public String deletar(int id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete from USUARIO_ADMIN where id_user = ?");
        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

        return  "Usuario deletado com sucesso!";
    }

}

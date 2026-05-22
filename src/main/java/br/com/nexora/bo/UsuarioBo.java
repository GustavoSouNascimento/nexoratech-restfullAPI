package br.com.nexora.bo;

import br.com.nexora.dao.UsuarioDao;
import br.com.nexora.entities.Usuario;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.RegistroDuplicadoException;
import br.com.nexora.excecoes.RegraDeNegocioException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsuarioBo {

    UsuarioDao userDao;

    private static final List<String> perfisPermitidos = Arrays.asList("Admin", "Leitura", "Operador");

    public void inserirBo(Usuario usuario) throws ClassNotFoundException, SQLException, RegraDeNegocioException, RegistroDuplicadoException {
        UsuarioDao userDao = new UsuarioDao();

        if (usuario.getPerfil() == null || !perfisPermitidos.contains(usuario.getPerfil()))
            throw new RegraDeNegocioException(
                    "Perfil invalido. Permitidos: Admin, Leitura, Operador.");

        for (Usuario u : userDao.selecionar()) {
            if (u.getEmail().equalsIgnoreCase(usuario.getEmail()))
                throw new RegistroDuplicadoException("email", usuario.getEmail());
        }

        userDao.inserir(usuario);
    }

    public ArrayList<Usuario> selecionarBo() throws ClassNotFoundException, SQLException {
        userDao = new UsuarioDao();
        return (ArrayList<Usuario>) userDao.selecionar();
    }

    public Usuario buscarIdBo(int id) throws SQLException, ClassNotFoundException {
        UsuarioDao userDao = new UsuarioDao();
        return userDao.buscarId(id);
    }

    public void atualizarBo (Usuario usuario) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException, RegraDeNegocioException {
        UsuarioDao userDao = new UsuarioDao();

        if (usuario.getPerfil() == null || !perfisPermitidos.contains(usuario.getPerfil()))
            throw new RegraDeNegocioException(
                    "Perfil invalido. Permitidos: Admin, Leitura, Operador.");

        userDao.atualizar(usuario);
    }

    public void deletarBo (int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException {
        UsuarioDao userDao = new UsuarioDao();
        Usuario existente = new UsuarioDao().buscarId(id);

        if (existente == null)
            throw new EntidadeNaoEncontradaException("Usuario", id);

        userDao.deletar(id);
    }
}

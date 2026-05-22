package br.com.nexora.bo;

import br.com.nexora.dao.VoluntarioDao;
import br.com.nexora.entities.Voluntario;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.RegistroDuplicadoException;

import java.sql.SQLException;
import java.util.ArrayList;

public class VoluntarioBo {

    VoluntarioDao volunDao;

    public void inserirBo(Voluntario voluntario) throws ClassNotFoundException, SQLException, RegistroDuplicadoException {
        VoluntarioDao volunDao = new VoluntarioDao();

        for (Voluntario v : volunDao.selecionar()) {
            if (v.getEmail().equalsIgnoreCase(voluntario.getEmail()))
                throw new RegistroDuplicadoException("email", voluntario.getEmail());
            if (v.getCro().equalsIgnoreCase(voluntario.getCro()))
                throw new RegistroDuplicadoException("CRO", voluntario.getCro());
        }

        volunDao.inserir(voluntario);
    }

    public ArrayList<Voluntario> selecionarBo() throws ClassNotFoundException, SQLException {
        volunDao = new VoluntarioDao();
        return (ArrayList<Voluntario>) volunDao.selecionar();
    }

    public Voluntario buscarIdBo(int id) throws SQLException, ClassNotFoundException {
        VoluntarioDao volunDao = new VoluntarioDao();
        return volunDao.buscarId(id);
    }

    public void atualizarBo (Voluntario voluntario) throws ClassNotFoundException, SQLException {
        VoluntarioDao volunDao = new VoluntarioDao();
        volunDao.atualizar(voluntario);
    }

    public void deletarBo (int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException {
        VoluntarioDao volunDao = new VoluntarioDao();
        Voluntario existente = new VoluntarioDao().buscarId(id);

        if (existente == null)
            throw new EntidadeNaoEncontradaException("Voluntario", id);

        volunDao.deletar(id);
    }
}

package br.com.nexora.bo;

import br.com.nexora.dao.AgendamentoDao;
import br.com.nexora.dao.PacienteDao;
import br.com.nexora.entities.Agendamento;
import br.com.nexora.entities.Paciente;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.OperacaoNaoPermitidaException;
import br.com.nexora.excecoes.RegistroDuplicadoException;

import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteBo {
    PacienteDao paciDao;

    public void inserirBo(Paciente paciente) throws ClassNotFoundException, SQLException, RegistroDuplicadoException {
        PacienteDao paciDao = new PacienteDao();

        for (Paciente p : paciDao.selecionar()) {
            if (p.getEmail().equalsIgnoreCase(paciente.getEmail()))
                throw new RegistroDuplicadoException("email", paciente.getEmail());
        }

        paciDao.inserir(paciente);
    }

    public ArrayList<Paciente> selecionarBo() throws ClassNotFoundException, SQLException {
        paciDao = new PacienteDao();
        return (ArrayList<Paciente>) paciDao.selecionar();
    }

    public Paciente buscarIdBo(int id) throws SQLException, ClassNotFoundException {
        PacienteDao paciDao = new PacienteDao();
        return paciDao.buscarId(id);
    }

    public void atualizarBo (Paciente paciente) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException {
        PacienteDao paciDao = new PacienteDao();

        Paciente existente = new PacienteDao().buscarId(paciente.getId());
        if (existente == null)
            throw new EntidadeNaoEncontradaException("Paciente", paciente.getId());

        paciDao.atualizar(paciente);
    }

    public void deletarBo (int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException, OperacaoNaoPermitidaException {
        PacienteDao paciDao = new PacienteDao();

        Paciente existente = new PacienteDao().buscarId(id);
        if (existente == null)
            throw new EntidadeNaoEncontradaException("Paciente", id);

        for (Agendamento a : new AgendamentoDao().selecionar()) {
            if (a.getPaciente() == id && "AGENDADO".equals(a.getStatus()))
                throw new OperacaoNaoPermitidaException("Nao e possivel excluir um paciente com agendamento ativo.");
        }

        paciDao.deletar(id);
    }
}

package br.com.nexora.bo;

import br.com.nexora.dao.AgendamentoDao;
import br.com.nexora.entities.Agendamento;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.OperacaoNaoPermitidaException;
import br.com.nexora.excecoes.RegraDeNegocioException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgendamentoBo {
    AgendamentoDao agendaDao;

    private static final List<String> statusPermitido = Arrays.asList("Agendado", "Realizado", "Cancelado");

    public void inserirBo(Agendamento agendamento) throws ClassNotFoundException, SQLException, RegraDeNegocioException {
        AgendamentoDao agendaDao = new AgendamentoDao();

        if (agendamento.getStatus() == null || !statusPermitido.contains(agendamento.getStatus()))
            throw new RegraDeNegocioException("Status invalido. Permitidos: Agendado, Realizado, Cancelado.");
        
        List<Agendamento> existentes = agendaDao.selecionar();
        for (Agendamento a : existentes) {
            if (a.getVoluntario() == agendamento.getVoluntario() && a.getDataHora().equals(agendamento.getDataHora()) && "Agendado".equals(a.getStatus()))
                throw new RegraDeNegocioException("Conflito de horario: o voluntario ja possui um agendamento nesse horario.");
        }

        agendaDao.inserir(agendamento);
    }

    public ArrayList<Agendamento> selecionarBo() throws ClassNotFoundException, SQLException {
        agendaDao = new AgendamentoDao();
        return (ArrayList<Agendamento>) agendaDao.selecionar();
    }

    public Agendamento buscarIdBo(int id) throws SQLException, ClassNotFoundException {
        AgendamentoDao agendaDao = new AgendamentoDao();
        return agendaDao.buscarId(id);
    }

    public void atualizarBo (Agendamento agendamento) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException, RegraDeNegocioException {
        AgendamentoDao agendaDao = new AgendamentoDao();

        Agendamento existente = agendaDao.buscarId(agendamento.getId());
        if (existente == null) throw new EntidadeNaoEncontradaException("Agendamento", agendamento.getId());

        if ("Realizado".equals(existente.getStatus())) throw new RegraDeNegocioException("Nao e possivel alterar um agendamento ja concluido.");

        if (agendamento.getStatus() == null || !statusPermitido.contains(agendamento.getStatus())) throw new RegraDeNegocioException("Status invalido. Permitidos: Agendado, Realizado, Cancelado.");

        agendaDao.atualizar(agendamento);
    }

    public void deletarBo (int id) throws ClassNotFoundException, SQLException, OperacaoNaoPermitidaException, EntidadeNaoEncontradaException {
        AgendamentoDao agendaDao = new AgendamentoDao();

        Agendamento existente = agendaDao.buscarId(id);
        if (existente == null) throw new EntidadeNaoEncontradaException("Agendamento", id);

        if ("AGENDADO".equals(existente.getStatus()))
            throw new OperacaoNaoPermitidaException("Nao e possivel excluir um agendamento ativo. Cancele-o primeiro.");

        agendaDao.deletar(id);
    }
}

package br.com.nexora.bo;

import br.com.nexora.dao.TriagemDao;
import br.com.nexora.entities.Triagem;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.OperacaoNaoPermitidaException;
import br.com.nexora.excecoes.RegraDeNegocioException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriagemBo {
    TriagemDao triaDao;

    private static final List<String> urgenciasPermitidas = Arrays.asList("Baixa", "Media", "Alta");
    private static final List<String> statusPermitidos = Arrays.asList("Concluida", "Pendente", "Cancelada");

    public void inserirBo(Triagem triagem) throws ClassNotFoundException, SQLException, RegraDeNegocioException {
        TriagemDao triaDao = new TriagemDao();

        if (triagem.getUrgencia() == null ||
                !urgenciasPermitidas.contains(triagem.getUrgencia()))
            throw new RegraDeNegocioException(
                    "Urgencia invalida. Permitidas: Baixa, Media, Alta.");

        for (Triagem t : triaDao.selecionar()) {
            if (t.getPaciente() == triagem.getPaciente() && "Concluida".equals(t.getStatus()))
                throw new RegraDeNegocioException(
                        "O paciente ja possui uma triagem em aberto. Encerre-a antes de criar uma nova.");
        }

        triaDao.inserir(triagem);
    }

    public ArrayList<Triagem> selecionarBo() throws ClassNotFoundException, SQLException {
        triaDao = new TriagemDao();
        // Regra de negocios
        return (ArrayList<Triagem>) triaDao.selecionar();
    }

    public Triagem buscarIdBo(int id) throws SQLException, ClassNotFoundException {
        TriagemDao triaDao = new TriagemDao();
        // Regra de negocios
        return triaDao.buscarId(id);
    }

    public void atualizarBo (Triagem triagem) throws ClassNotFoundException, SQLException, RegraDeNegocioException {
        TriagemDao triaDao = new TriagemDao();

        if (triagem.getStatus() == null ||
                !statusPermitidos.contains(triagem.getStatus()))
            throw new RegraDeNegocioException(
                    "Status invalido. Permitidos: Concluida, Pendente, Cancelada.");

        triaDao.atualizar(triagem);
    }

    public void deletarBo (int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException, OperacaoNaoPermitidaException {
        TriagemDao triaDao = new TriagemDao();

        Triagem existente = triaDao.buscarId(id);
        if (existente == null)
            throw new EntidadeNaoEncontradaException("Triagem", id);
        if (!"Cancelada".equals(existente.getStatus()))
            throw new OperacaoNaoPermitidaException(
                    "Somente triagens encerradas podem ser excluidas.");

        triaDao.deletar(id);
    }
}

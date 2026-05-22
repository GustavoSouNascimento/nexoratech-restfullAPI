package br.com.nexora.bo;

import br.com.nexora.dao.TratamentoDao;
import br.com.nexora.entities.Tratamento;
import br.com.nexora.excecoes.EntidadeNaoEncontradaException;
import br.com.nexora.excecoes.OperacaoNaoPermitidaException;
import br.com.nexora.excecoes.RegraDeNegocioException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TratamentoBo {
    TratamentoDao trataDao;

    private static final List<String> statusPermitido = Arrays.asList("Cancelado", "Concluido", "Em_Andamento");

    public void inserirBo(Tratamento tratamento) throws ClassNotFoundException, SQLException, RegraDeNegocioException {
        TratamentoDao trataDao = new TratamentoDao();

        if (tratamento.getStatus() == null || !statusPermitido.contains(tratamento.getStatus()))
            throw new RegraDeNegocioException("Status invalido. Permitidos: Em_Andamento, Concluido, Cancelado.");

        trataDao.inserir(tratamento);
    }

    public ArrayList<Tratamento> selecionarBo() throws ClassNotFoundException, SQLException {
        trataDao = new TratamentoDao();
        return (ArrayList<Tratamento>) trataDao.selecionar();
    }

    public Tratamento buscarIdBo(int id) throws SQLException, ClassNotFoundException {
        TratamentoDao trataDao = new TratamentoDao();
        return trataDao.buscarId(id);
    }

    public void atualizarBo (Tratamento tratamento) throws ClassNotFoundException, SQLException, RegraDeNegocioException {
        TratamentoDao trataDao = new TratamentoDao();

        if (tratamento.getStatus() == null || !statusPermitido.contains(tratamento.getStatus()))
            throw new RegraDeNegocioException(
                    "Status invalido. Permitidos: Em_Andamento, Concluido, Cancelado.");

        trataDao.atualizar(tratamento);
    }

    public void deletarBo (int id) throws ClassNotFoundException, SQLException, EntidadeNaoEncontradaException, OperacaoNaoPermitidaException {
        TratamentoDao trataDao = new TratamentoDao();

        Tratamento existente = trataDao.buscarId(id);
        if (existente == null)
            throw new EntidadeNaoEncontradaException("Tratamento", id);

        if ("Em_Andamento".equals(existente.getStatus()))
            throw new OperacaoNaoPermitidaException(
                    "Nao e possivel excluir um tratamento em andamento. Cancele-o primeiro.");

        trataDao.deletar(id);
    }
}

package br.com.nexora.excecoes;

public class EntidadeNaoEncontradaException extends Exception {

    public EntidadeNaoEncontradaException(String entidade, int id) {
        super(entidade + " com id " + id + " nao encontrado.");
    }
}

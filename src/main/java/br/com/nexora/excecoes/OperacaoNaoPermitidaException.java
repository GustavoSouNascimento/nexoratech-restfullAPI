package br.com.nexora.excecoes;


public class OperacaoNaoPermitidaException extends Exception {

    public OperacaoNaoPermitidaException(String mensagem) {
        super(mensagem);
    }
}

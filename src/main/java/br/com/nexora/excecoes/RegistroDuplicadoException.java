package br.com.nexora.excecoes;


public class RegistroDuplicadoException extends Exception {

    public RegistroDuplicadoException(String campo, String valor) {
        super("Ja existe um registro com " + campo + " igual a '" + valor + "'.");
    }
}

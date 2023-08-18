package br.ufrpe.moview.exception;

public class SenhaIncorretaException extends Exception{
    public SenhaIncorretaException() {
        super("Senha incorreta");
    }
}

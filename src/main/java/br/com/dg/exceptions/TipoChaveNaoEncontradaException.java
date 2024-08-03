package main.java.br.com.dg.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {

    private static final long serialVersionUID = 1L;

    public TipoChaveNaoEncontradaException(String message) {
        super(message);
    }
}

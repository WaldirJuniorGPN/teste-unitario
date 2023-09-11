package br.com.alura.tdd.infra;

public class FuncionarioException extends RuntimeException {
    public FuncionarioException(String mensagem) {
        super(mensagem);
    }
}

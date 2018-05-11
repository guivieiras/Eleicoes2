package exceptions;

public class NumeroInvalidoException extends Exception {

    public NumeroInvalidoException() {
        super("Erro: número de candidato tem que ser entre 01 e 98");
    }
    
}

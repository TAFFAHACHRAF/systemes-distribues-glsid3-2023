package taffah.enset.common_api.exceptions;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String s) {
        super(s);
    }
}

package example.demo.exception;

public class LoginException extends RuntimeException {
    public LoginException(String msg) {
        super(msg);
    }
}

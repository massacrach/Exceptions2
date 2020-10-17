package jm.section42;

public class RobotConnectionException extends RuntimeException {
    public RobotConnectionException(String message) {
        super(message);
        System.out.println(message);
    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
        System.out.println(message + "#2");
    }
}

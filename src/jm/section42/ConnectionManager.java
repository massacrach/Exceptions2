package jm.section42;

public class ConnectionManager implements RobotConnectionManager {
    ExceptionTypes exceptionType;

    public ConnectionManager(ExceptionTypes exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public RobotConnection getConnection() {
        if (exceptionType == ExceptionTypes.CONNECTION_EXCEPTION) {
            throw new RobotConnectionException(exceptionType.toString());
        }

        if (exceptionType == ExceptionTypes.CONNECTION_RANDOM_EXCEPTION) {
            throw new RuntimeException(exceptionType.toString());
        }

        return new Connection(exceptionType);
    }
}

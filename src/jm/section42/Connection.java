package jm.section42;

public class Connection implements RobotConnection {
    ExceptionTypes exceptionType;

    public Connection(ExceptionTypes exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public void moveRobotTo(int x, int y) {
        if (exceptionType == ExceptionTypes.MOVEMENT_EXCEPTION) {
            throw new RobotConnectionException(exceptionType.toString());
        }

        if (exceptionType == ExceptionTypes.MOVEMENT_RANDOM_EXCEPTION) {
            throw new RuntimeException(exceptionType.toString());
        }

        System.out.println("ROBOT MOVED");
    }

    @Override
    public void close() {
        if (exceptionType == ExceptionTypes.CLOSING_EXCEPTION) {
            throw new RobotConnectionException(exceptionType.toString());
        }

        if (exceptionType == ExceptionTypes.CLOSING_RANDOM_EXCEPTION) {
            throw new RuntimeException(exceptionType.toString());
        }

    }
}

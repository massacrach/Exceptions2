package jm.section42;

public class Main {

    public static void main(String[] args) {
	    RobotConnectionManager[] robotConnectionManagers = {
	        new ConnectionManager(ExceptionTypes.CONNECTION_EXCEPTION),
            new ConnectionManager(ExceptionTypes.CONNECTION_RANDOM_EXCEPTION),
            new ConnectionManager(ExceptionTypes.MOVEMENT_EXCEPTION),
            new ConnectionManager(ExceptionTypes.MOVEMENT_RANDOM_EXCEPTION),
            new ConnectionManager(ExceptionTypes.CLOSING_EXCEPTION),
            new ConnectionManager(ExceptionTypes.CLOSING_RANDOM_EXCEPTION),
            new ConnectionManager(ExceptionTypes.NONE)
        };

	    for (RobotConnectionManager robotConnectionManager : robotConnectionManagers) {
	        try {
                moveRobot(robotConnectionManager, 1, 2);
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }

        }
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int attempts = 0;
        boolean done = false;

        while (attempts < 3 && !done) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                done = true;
            } catch (RobotConnectionException robotConnectionException) {
                attempts++;
            }
        }

        if (!done) {
            throw new RobotConnectionException("ALL ATTEMPTS FAILED");
        }
    }
}

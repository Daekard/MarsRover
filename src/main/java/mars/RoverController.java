package mars;

/**
 * Convenience class for creating a moving objects of the type {@link Rover}.
 */
public class RoverController {

    long plateauX;
    long plateauY;

    /**
     * Creates a new controller for moving {@link Rover} instances on a plateau
     * @param plateauX  The upper limit of the X dimension of the plateau
     * @param plateauY The upper limit of the X dimension of the plateau
     */
    public RoverController(long plateauX, long plateauY) {
        this.plateauX = plateauX;
        this.plateauY = plateauY;
    }

    public String createAndNavigateRover(long startX, long startY, char heading, String directions) {
        Rover rover = new Rover(plateauX, plateauY, startX, startY, heading);
        rover.move(directions);
        return rover.toString();
    }
}

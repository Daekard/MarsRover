package mars;

/**
 * Convenience class for creating a moving objects of the type {@link Rover}.
 */
class RoverController {

    private final long plateauX;
    private final long plateauY;

    /**
     * Creates a new controller for moving {@link Rover} instances on a plateau
     * @param plateauX  The upper limit of the X dimension of the plateau
     * @param plateauY The upper limit of the X dimension of the plateau
     */
    public RoverController(long plateauX, long plateauY) {
        this.plateauX = plateauX;
        this.plateauY = plateauY;
    }

    /**
     * Creates a new rover at the specified coordinates and orientation and moves it according to the instructions.
     * @param startX        The initial X coordinate of the rover
     * @param startY        The initial Y coordinate of the rover
     * @param heading       The initial heading of the rover
     * @param directions    The set of instruction for moving the rover on the plateau
     * @return  A formatted string describing the final X and Y coordinates of the rover, and it's final heading
     */
    public String createAndNavigateRover(long startX, long startY, char heading, String directions) {
        Rover rover = new Rover(plateauX, plateauY, startX, startY, heading);
        rover.move(directions);
        return rover.toString();
    }
}

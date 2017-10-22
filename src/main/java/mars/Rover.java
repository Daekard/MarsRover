package mars;

/**
 * Represents a rover vehicle which can be directed to move across a two dimensional plane/plateau.
 */
public class Rover {

    private static final char MOVE = 'M';

    private Heading heading = Heading.N;
    private long x = 0;
    private long y = 0;
    private long plateauX = 0;
    private long plateauY = 0;

    /**
     * Creates a new instance of a rower which is initialized on a specified point corresponding to coordinates on a
     * two dimensional plateau.
     *
     * @param plateauX  The upper bound of the X axis of the plane which the rover should navigate
     * @param plateauY  The upper bound of the Y axis of the plane which the rover should navigate
     * @param startX    The initial X coordinate of the rover
     * @param startY    The initial Y coordinate of the rove
     * @param heading   The initial heading of the rover, corresponding to (N)orth, (S)outh, (E)ast, and (W)est
     * @throws IndexOutOfBoundsException if the initial location of the rover is beyond the bounds of the plateau
     * @throws IllegalArgumentException if the specified heading does not correspond to a value in the heading range
     */
    public Rover(long plateauX, long plateauY, long startX, long startY, char heading) {

        if (outOfRange(startX, plateauX) || outOfRange(startY, plateauY)) {
            throw new IndexOutOfBoundsException("Rover did not land on the plateau");
        }

        this.heading = Heading.valueOf(String.valueOf(heading));
        this.plateauX = plateauX;
        this.plateauY = plateauY;
        this.x = startX;
        this.y = startY;
    }

    /**
     * Moves the rover according to the directions specified in the provided parameter.
     * The parameter is to contain a combination of the following characters
     * <ul>
     *     <li>'L' which will rotate the rover 90 degrees anticlockwise</li>
     *     <li>'R' which will rotate the rover 90 degrees anticlockwise</li>
     *     <li>'M' which will move the rover forward in the current direction</li>
     * </ul>
     * Note that any unrecognised characters will be ignored.
     * @param directions    A case insensitive string of commands
     */
    public void move(String directions) {
        if (directions != null && directions.length() > 0) {
            directions = directions.toUpperCase();
            char[] directionArray = directions.toCharArray();
            for (Character d : directionArray) {
                if (Rotation.L.getRotor() == d) {
                    this.orient(Rotation.L);
                } else if (Rotation.R.getRotor() == d) {
                    this.orient(Rotation.R);
                } else if (MOVE == d) {
                    this.move();
                }
            }
        }
    }

    public Heading getHeading() {
        return heading;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    private boolean outOfRange(long destination, long limit) {
        return destination < 0 || destination > limit;
    }

    private void move() {
        // If oriented north or south, direct the rover to move along the Y axis
        if (this.heading.getDirection() % 2 == 0) {
            moveY();
        } else {
            moveX();
        }
    }

    private void moveY() {
        long upDown = Heading.N.equals(heading) ? 1 : -1;
        long newY = y + upDown;
        // Only move the rover if the destination does not fall outside the limits of the plateau
        if (!outOfRange(newY, plateauY)) {
            this.y = newY;
        }
    }

    private void moveX() {
        long leftRight = Heading.E.equals(heading) ? 1 : -1;
        long newX = x + leftRight;
        // Only move the rover if the destination does not fall outside the limits of the plateau
        if (!outOfRange(newX, plateauX)) {
            this.x = newX;
        }
    }

    /**
     * Reorients the rover by according to the {@link Rotation} direction
     * @param rotation  The
     */
    private void orient(Rotation rotation) {
        int newHeading = this.heading.ordinal() + rotation.getDirection();

        int resolved = newHeading < 0 ? newHeading + 4 : newHeading % 4;
        this.heading = Heading.getHeading(resolved);
    }

    private enum Rotation {
        L(-1, 'L'), R(1, 'R');

        private final int direction;
        private final char rotor;

        Rotation(int direction, char rotor) {
            this.direction = direction;
            this.rotor = rotor;
        }

        int getDirection() {
            return direction;
        }

        char getRotor() {
            return rotor;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(x) + " " + y + " " + heading.toString();
    }
}

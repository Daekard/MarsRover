package mars;

import org.junit.Assert;
import org.junit.Test;


public class RoverTest {

    @Test
    public void shouldPassTestCaseOne() {
        Rover objectUnderTest = new Rover(5, 5, 1, 2, 'N');
        String directions = "LMLMLMLMM";
        objectUnderTest.move(directions);

        Assert.assertEquals(1, objectUnderTest.getX());
        Assert.assertEquals(3, objectUnderTest.getY());
        Assert.assertEquals(Heading.N, objectUnderTest.getHeading());
    }

    @Test
    public void shouldPassTestCaseTwo() {
        Rover objectUnderTest = new Rover(5, 5, 3, 3, 'E');
        String directions = "MMRMMRMRRM";
        objectUnderTest.move(directions);

        Assert.assertEquals(5, objectUnderTest.getX());
        Assert.assertEquals(1, objectUnderTest.getY());
        Assert.assertEquals(Heading.E, objectUnderTest.getHeading());
    }

    @Test
    public void shouldPassTestCaseThree() {
        Rover objectUnderTest = new Rover(50, 50, 30, 20, 'E');
        String directions = "RRMLMMMRMLLMRMM";
        objectUnderTest.move(directions);

        Assert.assertEquals(29, objectUnderTest.getX());
        Assert.assertEquals(15, objectUnderTest.getY());
        Assert.assertEquals(Heading.S, objectUnderTest.getHeading());
    }

    @Test
    public void shouldPassTestCaseFour() {
        Rover objectUnderTest = new Rover(25, 92, 3, 17, 'E');
        String directions = "MMRMMMLLLMMRMMMLMMLMMMM";
        objectUnderTest.move(directions);

        Assert.assertEquals(1, objectUnderTest.getX());
        Assert.assertEquals(13, objectUnderTest.getY());
        Assert.assertEquals(Heading.S, objectUnderTest.getHeading());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenYPositionExceedsPlateau() {
        new Rover(5, 5, 0, 6, 'E');
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenXPositionExceedsPlateau() {
        new Rover(5, 5, 6, 0, 'E');
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenOrientationDoesNotExist() {
        new Rover(5, 5, 0, 0, 'B');
    }

    @Test
    public void shouldNotMoveRoverBeyondBoundOfPlateau() {
        long initialX = 10;
        long initialY = 10;
        Rover objectUnderTest = new Rover(10, 10, initialX, initialY, 'N');
        objectUnderTest.move("MMM");

        Assert.assertEquals(initialX, objectUnderTest.getX());
        Assert.assertEquals(initialY, objectUnderTest.getY());
        Assert.assertEquals(Heading.N, objectUnderTest.getHeading());
    }

    @Test
    public void roverShouldFaceInitialDirectionIfRotatedClockwiseFourTimes() {
        long initialX = 10;
        long initialY = 10;
        Rover objectUnderTest = new Rover(10, 10, initialX, initialY, 'N');
        objectUnderTest.move("RRRR");

        Assert.assertEquals(initialX, objectUnderTest.getX());
        Assert.assertEquals(initialY, objectUnderTest.getY());
        Assert.assertEquals(Heading.N, objectUnderTest.getHeading());
    }
    @Test
    public void roverShouldFaceInitialDirectionIfRotatedAntiClockwiseFourTimes() {
        long initialX = 7;
        long initialY = 3;
        Rover objectUnderTest = new Rover(10, 10, initialX, initialY, 'E');
        objectUnderTest.move("LLLL");

        Assert.assertEquals(initialX, objectUnderTest.getX());
        Assert.assertEquals(initialY, objectUnderTest.getY());
        Assert.assertEquals(Heading.E, objectUnderTest.getHeading());
    }
}

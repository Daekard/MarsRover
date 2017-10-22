package mars;

import org.junit.Assert;
import org.junit.Test;


public class RoverTest {

    @Test
    public void testRover() {
        Rover objectUnderTest = new Rover(5, 5, 1, 2, 'N');
        String directions = "LMLMLMLMM";
        objectUnderTest.move(directions);

        Assert.assertEquals(1, objectUnderTest.getX());
        Assert.assertEquals(3, objectUnderTest.getY());
        Assert.assertEquals(Heading.N, objectUnderTest.getHeading());
    }

    @Test
    public void testRover2() {
        Rover objectUnderTest = new Rover(5, 5, 3, 3, 'E');
        String directions = "MMRMMRMRRM";
        objectUnderTest.move(directions);

        Assert.assertEquals(5, objectUnderTest.getX());
        Assert.assertEquals(1, objectUnderTest.getY());
        Assert.assertEquals(Heading.E, objectUnderTest.getHeading());
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
        Rover objectUnderTest = new Rover(10, 10, 10, 10, 'N');
        objectUnderTest.move("MMM");

        Assert.assertEquals(initialX, objectUnderTest.getX());
        Assert.assertEquals(initialY, objectUnderTest.getY());
        Assert.assertEquals(Heading.N, objectUnderTest.getHeading());
    }
}
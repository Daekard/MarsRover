package mars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

class MarsRover {
    public static void main(String [] args)
    {
        System.out.print("Enter the path for the command file (e.g. c:\\path\\file.txt): ");
        Scanner stdin = new Scanner(System.in);
        String filePath = stdin.nextLine();
        stdin.close();

        try (Scanner in = new Scanner(new File(filePath)))
        {
            long plateauX = in.nextLong();
            long plateauY = in.nextLong();

            if (plateauX <=0 || plateauY <=0) {
                throw new IllegalArgumentException(
                        "The plateau size must consist of positive whole numbers greater than zero");
            }

            in.nextLine();
            RoverController controller = new RoverController(plateauX, plateauY);
            while (in.hasNextLine())
            {
                long roverX = in.nextLong();
                long roverY = in.nextLong();
                char orientation = in.next().charAt(0);
                in.nextLine();
                String directions = in.nextLine();

                try {
                    System.out.println(controller.createAndNavigateRover(roverX, roverY, orientation, directions));
                } catch (IndexOutOfBoundsException | IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (FileNotFoundException x) {
            System.out.println("Failed to find specified file: " + filePath);
        } catch (InputMismatchException x) {
            System.out.println("An error occurred while reading the file. Ensure file meets format specifications.");
        } catch (IllegalArgumentException x) {
            System.out.println(x.getMessage());
        }
    }
}

The program is designed to take as input the name of a file containing the X and Y limits of the plateau, followed by the initial position and instructions for each rover.
An example file can be found in the included 'test.txt'.

In order to complete the exercise a number of assumptions have been made. I recognise that these assumptions may not be correct, or in the spirit of the exercise.
* The initial parameters for the plateau size must be positive whole numbers greater than zero (i.e. X & Y cannot go into the negative)
* Rovers cannot collide or interact, and can occupy the same space on the plateau. If it were the case that they could interact, each rover's position could be recorded (e.g. on a 2 dimensional array) and checked for each movement a subsequent rover made.
* If a rover is initialized in a position that is beyond the bounds of the plateau, this is considered an error and an exception recorded.
* If a rover attempts to move beyond the bounds of the plateau, it will remain stationary.
* If the instructions for a rover contain an unknown command (i.e. not 'M', 'L', or 'R'), the command is ignored.
* If a direction other than NSEW is provided, this constitutes an illegal argument, and an exception is thrown.
* The output is printed to standard out. It is unknown if the output should be recorded in another destination (e.g. file).

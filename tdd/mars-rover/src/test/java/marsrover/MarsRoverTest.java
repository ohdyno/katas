package marsrover;

import java.io.*;
import java.util.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MarsRoverTest {
    @Test
    void runRover() {
        Integer maxX = 5;
        Integer maxY = 5;
        String moves = "lmrmlmrm";

        MarsRover testRover = new MarsRover(0,0, 'e');
        for (char move: moves.toCharArray()) {
            try {
                testRover.runCommand(move);
            }
            catch (Error e) {
                e.printStackTrace();
            }
        }

        assertEquals("2 2 E" , testRover.outputLocation());
    }

    @Test
    void roverLeftNToW(){

    }

    @Test
    void roverRightWtoN(){

    }
}

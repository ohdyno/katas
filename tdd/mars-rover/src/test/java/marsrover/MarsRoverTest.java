package marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MarsRoverTest {
    @Test
    void runRover() {
//        given
        Integer maxX = 5;
        Integer maxY = 5;
        MarsRover testRover = new MarsRover(0,0, 'E', maxX, maxY);

//        when
        String moves = "LMRMLMRM";
        for (char move: moves.toCharArray()) {
            try {
                testRover.runCommand(move);
            }
            catch (Error e) {
                e.printStackTrace();
            }
        }

//        then
        assertEquals("2 2 E" , testRover.outputLocation());
    }

    @Test
    void roverLeftNToW(){
//         given
        Integer maxX = 5;
        Integer maxY = 5;
        MarsRover testRover = new MarsRover(0,0, 'N', maxX, maxY);
//        when
        char moves = 'L';
        testRover.runCommand(moves);

//        then
        assertEquals("0 0 W", testRover.outputLocation());
    }

    @Test
    void roverRightWtoN(){
//         given
        Integer maxX = 5;
        Integer maxY = 5;
        MarsRover testRover = new MarsRover(0,0, 'W', maxX, maxY);
//        when
        char moves = 'R';
        testRover.runCommand(moves);

//        then
        assertEquals("0 0 N", testRover.outputLocation());
    }

    @Test
    void locationWrap(){
//      given
        Integer maxX = 5;
        Integer maxY = 5;
        MarsRover testRover = new MarsRover(5,5, 'N', maxX, maxY);
        MarsRover testRover2 = new MarsRover(0,0, 'S', maxX, maxY);

//        when
        String moves = "MRM";
        for (char move : moves.toCharArray()) {
            testRover.runCommand(move);
            testRover2.runCommand(move);
        }
//        then
        assertEquals("0 0 E", testRover.outputLocation());
        assertEquals("5 5 W", testRover2.outputLocation());
    }
}

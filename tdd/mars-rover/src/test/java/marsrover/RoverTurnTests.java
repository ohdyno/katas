package marsrover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTurnTests {
    @Test
    void turnLeft() {
        final Rover rover = new Rover(0, 0, Direction.North);
        rover.process("l");
        assertThat(rover.isFacing(Direction.West)).isTrue();
    }
}

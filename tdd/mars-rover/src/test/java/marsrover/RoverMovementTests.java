package marsrover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverMovementTests {
    @Test
    void forward() {
        final Rover rover = new Rover(1, 1, Direction.North);
        rover.process(Command.Forward);
        assertThat(rover.isLocatedAt(1, 0)).isTrue();
        assertThat(rover.isLocatedAt(1, 1)).isFalse();
    }
}

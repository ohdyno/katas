package marsrover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTurnTests {
    @Test
    void turnLeftWhenFacingNorth() {
        final Rover rover = new Rover(0, 0, Direction.North);
        rover.process(Command.Left);
        assertThat(rover.isFacing(Direction.West)).isTrue();
    }

    @Test
    void turnRightWhenFacingNorth() {
        final Rover rover = new Rover(0, 0, Direction.North);
        rover.process(Command.Right);
        assertThat(rover.isFacing(Direction.East)).isTrue();
    }

    @Test
    void turnLeftWhenFacingEast() {
        final Rover rover = new Rover(0, 0, Direction.East);
        rover.process(Command.Left);
        assertThat(rover.isFacing(Direction.North)).isTrue();
    }

    @Test
    void turnRightWhenFacingEast() {
        final Rover rover = new Rover(0, 0, Direction.East);
        rover.process(Command.Right);
        assertThat(rover.isFacing(Direction.South)).isTrue();
    }

    @Test
    void turnLeftWhenFacingSouth() {
        final Rover rover = new Rover(0, 0, Direction.South);
        rover.process(Command.Left);
        assertThat(rover.isFacing(Direction.East)).isTrue();
    }

    @Test
    void turnRightWhenFacingSouth() {
        final Rover rover = new Rover(0, 0, Direction.South);
        rover.process(Command.Right);
        assertThat(rover.isFacing(Direction.West)).isTrue();
    }

    @Test
    void turnLeftWhenFacingWest() {
        final Rover rover = new Rover(0, 0, Direction.West);
        rover.process(Command.Left);
        assertThat(rover.isFacing(Direction.South)).isTrue();
    }

    @Test
    void turnRightWhenFacingWest() {
        final Rover rover = new Rover(0, 0, Direction.West);
        rover.process(Command.Right);
        assertThat(rover.isFacing(Direction.North)).isTrue();
    }
}

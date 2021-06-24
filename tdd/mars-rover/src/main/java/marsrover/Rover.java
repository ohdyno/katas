package marsrover;

public class Rover {
    private Coordinate coordinate;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.coordinate = new Coordinate(x, y);
        this.direction = direction;
    }

    public void process(Command command) {
        if (command.isForTurning()) {
            this.direction = direction.process(command);
        }
        this.coordinate = coordinate.process(command);
    }

    public boolean isFacing(Direction direction) {
        return this.direction.equals(direction);
    }

    public boolean isLocatedAt(int x, int y) {
        return this.coordinate.isAt(x, y);
    }

    private static class Coordinate {
        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate process(Command command) {
            if (command.equals(Command.Forward)) {
                return new Coordinate(x, y - 1);
            }
            return this;
        }

        private boolean isAt(int x, int y) {
            return this.x == x && this.y == y;
        }
    }
}

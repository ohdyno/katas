package marsrover;

public enum Direction {
    West {
        @Override
        Direction process(Command command) {
            if (command.equals(Command.Left)) return South;
            return North;
        }
    },

    East {
        @Override
        public Direction process(Command command) {
            if (command.equals(Command.Left)) return North;
            return South;
        }
    },

    North {
        @Override
        public Direction process(Command command) {
            if (command.equals(Command.Left)) return West;
            return East;
        }
    },

    South {
        @Override
        Direction process(Command command) {
            if (command.equals(Command.Left)) return East;
            return West;
        }
    };

    abstract Direction process(Command command);
}

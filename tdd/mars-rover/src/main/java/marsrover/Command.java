package marsrover;

public enum Command {
    Right {
        @Override
        public boolean isForTurning() {
            return true;
        }
    },

    Left {
        @Override
        public boolean isForTurning() {
            return true;
        }
    },

    Forward;

    public boolean isForTurning() {
        return false;
    }
}

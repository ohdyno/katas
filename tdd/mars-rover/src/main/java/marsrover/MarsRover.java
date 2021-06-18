package marsrover;

public class MarsRover {
    private Integer posX;
    private Integer posY;
    private Directions direction;
    private enum Directions
    {
        N{ public Directions Left(){ return Directions.W; } },
        E,
        S,
        W{ public Directions Right(){ return Directions.N; } };

        static final Directions[] VALUES = values();
        public Directions Left(){return VALUES[ordinal() - 1];  }
        public Directions Right(){ return VALUES[ordinal() + 1]; }
    }

    public MarsRover(Integer x, Integer y, char dir){
        posX = x;
        posY = y;

        switch (dir) {
            case 'n' | 'N':
                direction = Directions.N;
                break;
            case 'e' | 'E':
                direction = Directions.E;
                break;
            case 's' | 'S':
                direction = Directions.S;
                break;
            case 'w' | 'W':
                direction = Directions.W;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dir);
        }
    }

    public void runCommand(char command){
        switch (command){
            case 'l' | 'L':
                turnLeft();
                break;
            case 'r' | 'R':
                turnRight();
                break;
            case 'm' | 'M':
                move();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }

    private void turnLeft(){
        direction = direction.Left();
    }

    private void turnRight(){
        direction = direction.Right();
    }

    private void move(){
        switch (direction){
            case N:
                posY++;
                break;
            case E:
                posX++;
                break;
            case S:
                posY--;
                break;
            case W:
                posX--;
                break;
        }
    }

    // to std out
    public void printToSTDOut(){
        System.out.print(outputLocation());
    }

    // for file output
    public String outputLocation(){
        return posX.toString() + " " + posY.toString() + " " + direction.toString();
    }
};

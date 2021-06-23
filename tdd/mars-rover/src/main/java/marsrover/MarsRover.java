package marsrover;

import java.util.Dictionary;

public class MarsRover {
    private Integer posX;
    private Integer posY;
//    public Location location;
//    private Dictionary<String, Integer> location;

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
    private Directions direction;

    public MarsRover(Integer x, Integer y, char dir, Integer maxX, Integer maxY){
        posX = x;
        posY = y;


/*
        location.x = x;
        location.y = y;
        location.maxX = maxX;
        location.maxY = maxY;
*/


        switch (dir) {
            case 'N':
                direction = Directions.N;
                break;
            case 'E':
                direction = Directions.E;
                break;
            case 'S':
                direction = Directions.S;
                break;
            case 'W':
                direction = Directions.W;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dir);
        }
    }

    public void runCommand(char command){
        switch (command){
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'M':
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

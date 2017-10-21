public class Grid {

    int row;
    int col;
    int distanceUnit;
    int distanceBetweenRow;
    int distanceBetweenCol;
    TrafficLight[][] City;
    int turningLanes;
    int forwardLanes;
    static int turnLanes = 2;
    static int forLanes = 2;
    int maxCars;


    Grid(int r, int c, int tLane, int fLane, int disRow, int disCol){
        row = r;
        col = c;
        turningLanes = tLane;
        forwardLanes = fLane;
        distanceUnit = Car.length + Car.clearance;
        distanceBetweenRow = disRow;
        distanceBetweenCol = disCol;
        maxCars = (tLane + fLane) * (r*((c-1)*distanceBetweenCol))+(c*((r-1)*distanceBetweenRow))

        City = new TrafficLight[row][col];
    }
}

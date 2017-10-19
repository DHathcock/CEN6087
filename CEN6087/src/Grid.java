public class Grid {

    int row;
    int col;
    TrafficLight[][] City;
    int turningLanes;
    int forwardLanes;


    Grid(int r, int c, int tLane, int fLane){
        row = r;
        col = c;
        turningLanes = tLane;
        forwardLanes = fLane;

        City = new TrafficLight[row][col];
    }
}

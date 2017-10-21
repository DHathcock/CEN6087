import com.google.gson.JsonObject;
import java.util.concurrent.ThreadLocalRandom;


public class CarGenerator {
    private  JsonObject CarConfiguration;
    private JsonObject GridConfiguration;

    public CarGenerator(JsonObject carConfiguration, JsonObject gridConfiguration) {
        CarConfiguration = carConfiguration;
        GridConfiguration= gridConfiguration;
    }

    public Car Create(int time) {
        int size = CarConfiguration.get("Size").getAsInt();
        int cruisingSpeed = CarConfiguration.get("CruisingSpeed").getAsInt();
        int acceleration = CarConfiguration.get("Acceleration").getAsInt();
        int deceleration = CarConfiguration.get("Deceleration").getAsInt();
        int maxY = GridConfiguration.get("NumberOfStreets").getAsInt();
        int maxX = GridConfiguration.get("NumberOfAvenues").getAsInt();
        Point entryPoint;

        // Generate path
        // at a specific point,car can only go two directions
        // at a specific entry point, because we do not allow exit grid immediately
        // maybe only one direction is available.
        // NOT allow car exit grid immediately
        int maxNumOfTurns = GridConfiguration.get("MaxNumOfTurns").getAsInt();
        int numOfTurns = 0;
        // get start point and start direction
        // Denote NS(SN) direction is 0, EW(WS) direction is 1
        entryPoint = getStartPoint(maxX,maxY);
        int direction = ThreadLocalRandom.current().nextInt(0,2);
        Point prevPoint;
        Point currPoint = entryPoint.clone();
        Point [] turnPoint = new Point[maxNumOfTurns];
        while(numOfTurns <= maxNumOfTurns)
        {
            prevPoint = currPoint;
            currPoint = getNextPoint(currPoint,maxX,maxY,direction);
            if(numOfTurns == maxNumOfTurns)
                break;
            if(prevPoint.compareTo(currPoint) == 0)
            {
                // at start point, if the direction results car run out of grid, reset
                if(numOfTurns == 0)
                {
                    direction = direction ^ 1;
                    continue;
                }
                // car runs to edge
                else
                {
                    numOfTurns--;
                    break;
                }
            }
            turnPoint[numOfTurns] = currPoint.clone();
            direction = direction ^ 1;
            numOfTurns++;
        }
        // if currPoint is not on edge, set it to edge point
        if(!(currPoint.X == 0 || currPoint.X == maxX-1 || currPoint.Y == 0 || currPoint.Y == maxY-1)){
            if(direction == 0) {
                if(currPoint.X % 2 == 0) {
                    currPoint.Y = maxY-1;
                }
                else{
                    currPoint.Y = 0;
                }
            }
            else {
                if(currPoint.Y % 2 == 0) {
                    currPoint.X = 0;
                }
                else {
                    currPoint.X = maxX - 1;
                }
            }
        }

        return new Car(size,cruisingSpeed,acceleration,deceleration,entryPoint,currPoint,turnPoint,numOfTurns,time);
    }

    // Since it is rectangle grid, total number of points on edge is (maxX + maxY) * 2 -4
    private Point getStartPoint(int maxX, int maxY)
    {
        int totalNumOfPoint = (maxX+maxY) * 2 - 4;
        int rand = ThreadLocalRandom.current().nextInt(1,totalNumOfPoint+1);
        Point newPoint = new Point();
        // random point is on the top side
        if(rand <= maxX)
        {
            newPoint.set(0,rand-1);
        }
        // random point is on the right side
        else if(rand <= maxX+ maxY -1)
        {
            newPoint.set(maxX-1,rand-maxX);
        }
        // random point is on the bottom side
        else if(rand <= 2*maxX+maxY-2)
        {
            newPoint.set(2*maxX+maxY-2-rand,maxY-1);
        }
        // random point is on the left side
        else
        {
            newPoint.set(2*(maxX+maxY)-rand-3,0);
        }
        return newPoint;
    }



    // Denote NS(SN) direction is 0, EW(WS) direction is 1
    private Point getNextPoint(Point currPoint, int maxX, int maxY, int direction)
    {
        Point nextPoint = currPoint.clone();
        if(direction == 1)
        {
            if(currPoint.Y % 2 == 1)
                //nextPoint.X = ThreadLocalRandom.current().nextInt(currPoint.X+1,maxX);
                nextPoint.X = myRandomGenerator(currPoint.X+1,maxX);
            else
                //nextPoint.X = ThreadLocalRandom.current().nextInt(0,currPoint.X);
                nextPoint.X = myRandomGenerator(0,currPoint.X);
        }
        else
        {
            if(currPoint.X % 2 == 0)
//                nextPoint.Y = ThreadLocalRandom.current().nextInt(currPoint.Y+1,maxY);
                nextPoint.Y = myRandomGenerator(currPoint.Y+1,maxY);
            else
//                nextPoint.Y = ThreadLocalRandom.current().nextInt(0,currPoint.Y);
                nextPoint.Y = myRandomGenerator(0,currPoint.Y);
        }
        return nextPoint;
    }

    private int myRandomGenerator(int min,int max) {
        if (min == max && min != 0)
            return max-1;
        else if (min == max && min == 0)
            return 0;
        return ThreadLocalRandom.current().nextInt(min,max);
    }

//    private boolean isInGrid(Point point,int maxX, int maxY)
//    {
//        if(point.X < maxX && point.Y < maxY)
//            return true;
//        return false;
//    }
//
//    private boolean isOnEdge(Point currPoint,int maxX, int maxY) {
//        return (currPoint.X == 0 || currPoint.X == maxX-1 || currPoint.Y == 0 || currPoint.Y == maxY-1);
//    }
}

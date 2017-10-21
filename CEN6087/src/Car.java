import java.util.Queue;

public class Car {
    static int carIDCounter;
    int carID;
    static int averageLength;
    static int clearance;
    Point entryPoint;
    Point exitPoint;
    int entryTime;
    int exitTime;
    int speed;
    int acceleration;
    int length;
    Point[] path;
    Hashmap<TrafficLight> waitingList;

    Car(Point entryLoc, Point exitLoc, int enterTime; int exTime; int s, int a, int l){
        carID = ++carIDCounter;
        entryPoint = entryLoc;
        exitPoint = exitLoc;
        speed = s;
        acceleration = a;
        length = l;
    }


}

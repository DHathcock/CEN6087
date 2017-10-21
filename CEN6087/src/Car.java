import java.util.Queue;

public class Car {
    public enum Light_Status{
        RED, YELLOW, GREEN
    }
    static int carID;
    Point entryPoint;
    Point exitPoint;
    int entryTime;
    int exitTime;
    int speed;
    int acceleration;
    int length;
    int clearance;

    Point[] path;
    Hashmap<TrafficLight> waitingList;
}

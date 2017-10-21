import java.util.Queue;

public class TrafficLight {
    public enum Light_Status{
        RED, YELLOW, GREEN
    }
    Point trafficLight_ID;
    Point location;
    int[] redLight_Cycle;
    int[] yellowLight_Cycle;
    int[] greenLight_Cycle;
    char scheduling;
    Queue<Car>[] NS_lanes;
    Queue<Car>[] EW_lanes;

    TrafficLight(Point loc, int[] red_Cycle, int[] yellow_Cycle, int[] green_Cycle){
        location = loc;
        redLight_Cycle = red_Cycle;
        yellowLight_Cycle = yellow_Cycle;
        greenLight_Cycle = green_Cycle;
        NS_lanes = new Queue[Grid.turnLanes + Grid.forLanes];
        EW_lanes = new Queue[Grid.turnLanes + Grid.forLanes];
    }
}

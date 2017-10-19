import java.util.Queue;

public class TrafficLight {
    public enum Light_Status{
        RED, YELLOW, GREEN
    }
    static Point trafficLight_ID;
    Point location;
    int[] redLight_Cycle;
    int[] yellowLight_Cycle;
    int[] greenLight_Cycle;
    char scheduling;
    Queue[] lanes;
}

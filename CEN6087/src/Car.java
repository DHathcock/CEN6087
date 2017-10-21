public class Car {
    private final int Size;
    private final int CruisingSpeed;
    private final int Acceleration;
    private final int Deceleration;
    private final Point EntryPoint;
    private final Point ExitPoint;
    private final Point[] TurnPoint;
    private final int NumOfTurns;
    private final int EnterTime;
    private int ExitTime;

    public Car(int size, int cruisingSpeed, int acceleration, int deceleration, Point entryPoint, Point exitPoint, Point[] turnPoint, int numOfTurns, int enterTime) {
        this.Size = size;
        this.CruisingSpeed = cruisingSpeed;
        this.Acceleration = acceleration;
        this.Deceleration = deceleration;
        this.EntryPoint = entryPoint;
        this.ExitPoint = exitPoint;
        this.TurnPoint = turnPoint;
        this.NumOfTurns = numOfTurns;
        this.EnterTime = enterTime;
    }
}
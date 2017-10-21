import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Generator g = new Generator("configuration/default.json");
        CarGenerator CG = new CarGenerator(g.GetCar(), g.GetGrid());
        Car car = CG.Create(5);
    }
}
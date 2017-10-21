import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Generator {
    protected final JsonObject Configuration;

    public Generator(String jsonFileName) throws IOException {
        String JsonFile = new String(Files.readAllBytes(Paths.get(jsonFileName)));
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(JsonFile);
        this.Configuration = jsonTree.getAsJsonObject();
    }

    public JsonObject GetGrid() {
        return this.Configuration.getAsJsonObject("Grid");
    }

    public JsonObject GetCar() {
        return this.Configuration.getAsJsonObject("Car");
    }

    public JsonObject GetTrafficLight() {
        return this.Configuration.getAsJsonObject("TrafficLight");
    }

    public JsonObject GetSchedulingScheme() {
        return this.Configuration.getAsJsonObject("SchedulingScheme");
    }
}
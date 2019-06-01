import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.*;

public class WeatherData {

    private static final String PROJECT_DIRECTORY = System.getProperty("user.dir");
    private static final String JSON_PATH = PROJECT_DIRECTORY + "/weather_data.json";
    private static final String SCRIPT_PATH = PROJECT_DIRECTORY + "/scripts/retrieve_weather_data.sh";
    private static final File JSON_FILE = new File(JSON_PATH);

    public Map<String, Double> sortedMap = new TreeMap<String, Double>(Collections.reverseOrder());

    public void mapJson() {
        outputJson();
        JsonArray dateDataList = parseJson();

        for(JsonElement element : dateDataList) {
            JsonObject x = element.getAsJsonObject();
            JsonObject y = x.getAsJsonObject("main");

            String dateStamp = x.get("dt_txt").getAsString();
            Double fahrenheit = convertKelvinToFahrenheit(y.get("temp").getAsDouble());

            sortedMap.put(dateStamp, fahrenheit);
        }

        deleteJson();
    }

    private void outputJson() {
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec(SCRIPT_PATH);
            waitForJsonExistence();
        } catch (Exception exception) {
            System.out.println("Failed to run script from" + " " + SCRIPT_PATH);
        }
    }

    private void waitForJsonExistence() throws InterruptedException {
        while(!JSON_FILE.exists()) {
            Thread.sleep(250);
        }
    }

    private JsonArray parseJson() {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(new FileReader(JSON_FILE), JsonObject.class);

            return jsonObject.getAsJsonArray("list");
        }
        catch(IOException exception) {
            System.out.println("File not found from" + " " + JSON_PATH);
        }

        return null;
    }

    private Double convertKelvinToFahrenheit(Double kelvin) {
        return ((kelvin - 273.15) * (9/5) + 32);
    }

    private void deleteJson() {
        if (JSON_FILE.exists()) {
            JSON_FILE.delete();
        }
    }
}

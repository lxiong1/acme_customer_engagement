import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Outreach {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private Map<String, Double> sortedMap = new TreeMap<String, Double>();
//    private Map<String, Double> averageTemperatureMap = new HashMap<String, Double>();

    public Outreach(WeatherData weatherData) {
        this.sortedMap = weatherData.sortedMap;
    }

    public void conclusion() {
        for (Map.Entry<String, Double> entry : sortedMap.entrySet()) {
            if(entry.getKey().contains("2019-06-02") && (entry.getKey().contains("12:00:00") || entry.getKey().contains("18:00:00"))) {
                System.out.println("It is" + " " + entry.getValue() + " " + "degrees fahrenheit" + " " + entry.getKey());
            } else if(entry.getKey().contains("2019-06-03") && (entry.getKey().contains("12:00:00") || entry.getKey().contains("18:00:00"))) {
                System.out.println("It is" + " " + entry.getValue() + " " + "degrees fahrenheit on" + " " + entry.getKey());
            } else if(entry.getKey().contains("2019-06-04") && (entry.getKey().contains("12:00:00") || entry.getKey().contains("18:00:00"))) {
                System.out.println("It is" + " " + entry.getValue() + " " + "degrees fahrenheit on" + " " + entry.getKey());
            } else if(entry.getKey().contains("2019-06-05") && (entry.getKey().contains("12:00:00") || entry.getKey().contains("18:00:00"))) {
                System.out.println("It is" + " " + entry.getValue() + " " + "degrees fahrenheit on" + " " + entry.getKey());
            } else if(entry.getKey().contains("2019-06-06") && (entry.getKey().contains("12:00:00") || entry.getKey().contains("18:00:00"))) {
                System.out.println("It is" + " " + entry.getValue() + " " + "degrees fahrenheit on" + " " + entry.getKey());
            }
        }
    }

//    private void calculateAverageTemperature() {
//        Double averageTemperature = 0.0;
//        Calendar calendar = Calendar.getInstance();
//
//        for (Map.Entry<String, Double> entry : sortedMap.entrySet()) {
//            if(entry.getKey().contains(currentDate())) {
//                averageTemperature += entry.getValue();
//                if(!entry.getKey().contains(currentDate())) {
//                    averageTemperatureMap.put(entry.getKey(), averageTemperature);
//                }
//            }
//        }
//    }

//    private String currentDate() {
//        Date date = new Date();
//
//        return DATE_FORMAT.format(date);
//    }
}

public class Runner {
    public static void main(String[] args) {
        WeatherData weatherData =  new WeatherData();
        weatherData.mapJson();

        Outreach outreach = new Outreach(weatherData);
        outreach.conclusion();
    }   
}

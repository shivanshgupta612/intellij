package LowLevelDesign.DesignPatterns.ObserverPattern;

public class Main {
    public static void main(String[] args) {
        // Subjects
        CricketMatch cricketMatch = new CricketMatch();
        WeatherStation weatherStation = new WeatherStation();

        // Observer TV
        TV tv = new TV();

        // Attach TV to both subjects
        cricketMatch.attach(tv);
        weatherStation.attach(tv);

        // Set strategy for cricket match updates
        tv.setStrategy(new CricketMatchUpdateStrategy(tv, cricketMatch));
        cricketMatch.setScore("100/3");

        // Set strategy for weather station updates
        tv.setStrategy(new WeatherStationUpdateStrategy(tv, weatherStation));
        weatherStation.setTemperature("30°C");

        // Update cricket score again
        tv.setStrategy(new CricketMatchUpdateStrategy(tv, cricketMatch));
        cricketMatch.setScore("150/4");

        // Update weather temperature again
        tv.setStrategy(new WeatherStationUpdateStrategy(tv, weatherStation));
        weatherStation.setTemperature("28°C");
    }
}

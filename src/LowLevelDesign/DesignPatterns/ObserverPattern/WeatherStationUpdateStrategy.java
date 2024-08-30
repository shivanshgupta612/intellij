package LowLevelDesign.DesignPatterns.ObserverPattern;

class WeatherStationUpdateStrategy implements UpdateStrategy {
    private TV tv;
    private WeatherStation weatherStation;

    public WeatherStationUpdateStrategy(TV tv, WeatherStation weatherStation) {
        this.tv = tv;
        this.weatherStation = weatherStation;
    }

    @Override
    public void executeUpdate() {
        tv.setLastTemperature(weatherStation.getTemperature());
        tv.displayTemperature();
    }
}
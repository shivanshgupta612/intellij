package LowLevelDesign.DesignPatterns.ObserverPattern;

class TV implements Observer {
    private UpdateStrategy updateStrategy;
    private String lastScore;
    private String lastTemperature;

    public void setStrategy(UpdateStrategy updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    @Override
    public void update() {
        if (updateStrategy != null) {
            updateStrategy.executeUpdate();
        }
    }

    public void setLastScore(String lastScore) {
        this.lastScore = lastScore;
    }

    public void setLastTemperature(String lastTemperature) {
        this.lastTemperature = lastTemperature;
    }

    public void displayScore() {
        System.out.println("TV Display -> Cricket Score: " + lastScore);
    }

    public void displayTemperature() {
        System.out.println("TV Display -> Weather Temperature: " + lastTemperature);
    }
}

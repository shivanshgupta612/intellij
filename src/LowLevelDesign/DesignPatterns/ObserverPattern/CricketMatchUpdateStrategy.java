package LowLevelDesign.DesignPatterns.ObserverPattern;

class CricketMatchUpdateStrategy implements UpdateStrategy {
    private TV tv;
    private CricketMatch cricketMatch;

    public CricketMatchUpdateStrategy(TV tv, CricketMatch cricketMatch) {
        this.tv = tv;
        this.cricketMatch = cricketMatch;
    }

    @Override
    public void executeUpdate() {
        tv.setLastScore(cricketMatch.getScore());
        tv.displayScore();
    }
}

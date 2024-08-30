package LowLevelDesign.DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

class CricketMatch implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String score;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
        notifyObservers();
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}

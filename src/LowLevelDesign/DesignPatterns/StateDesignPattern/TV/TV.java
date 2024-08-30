package LowLevelDesign.DesignPatterns.StateDesignPattern.TV;

public class TV {
    private State offState;
    private State onState;
    private State mutedState;

    private State currentState;

    public TV() {
        offState = new OffState(this);
        onState = new OnState(this);
        mutedState = new MutedState(this);

        currentState = offState; // TV is off initially
    }

    public void setCurrentState(State state) {
        currentState = state;
    }

    public State getOffState() {
        return offState;
    }

    public State getOnState() {
        return onState;
    }

    public State getMutedState() {
        return mutedState;
    }

    public void pressPowerButton() {
        currentState.pressPowerButton();
    }

    public void pressVolumeButton() {
        currentState.pressVolumeButton();
    }

    public void pressMuteButton() {
        currentState.pressMuteButton();
    }
}

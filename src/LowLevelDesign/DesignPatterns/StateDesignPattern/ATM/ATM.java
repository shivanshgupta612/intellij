package LowLevelDesign.DesignPatterns.StateDesignPattern.ATM;

public class ATM {
    private State idleState;
    private State hasCardState;
    private State authenticatedState;
    private State outOfCashState;

    private State currentState;
    private int cashInMachine;

    public ATM(int initialCash) {
        idleState = new IdleState(this);
        hasCardState = new HasCardState(this);
        authenticatedState = new AuthenticatedState(this);
        outOfCashState = new OutOfCashState(this);

        cashInMachine = initialCash;
        if (cashInMachine > 0) {
            currentState = idleState;
        } else {
            currentState = outOfCashState;
        }
    }

    public void setState(State state) {
        currentState = state;
    }

    public void insertCard() {
        currentState.insertCard();
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void enterPin(int pin) {
        currentState.enterPin(pin);
    }

    public void requestCash(int amount) {
        currentState.requestCash(amount);
    }

    public State getIdleState() {
        return idleState;
    }

    public State getHasCardState() {
        return hasCardState;
    }

    public State getAuthenticatedState() {
        return authenticatedState;
    }

    public State getOutOfCashState() {
        return outOfCashState;
    }

    public int getCashInMachine() {
        return cashInMachine;
    }

    public void setCashInMachine(int cashInMachine) {
        this.cashInMachine = cashInMachine;
    }
}

package LowLevelDesign.DesignPatterns.StateDesignPattern.ATM;

interface State {
    void insertCard();
    void ejectCard();
    void enterPin(int pin);
    void requestCash(int amount);
}


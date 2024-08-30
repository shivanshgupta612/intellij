package LowLevelDesign.DesignPatterns.StateDesignPattern.ATM;

// Concrete state for when the ATM is out of cash
class OutOfCashState implements State {
    private ATM atm;

    public OutOfCashState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("ATM is out of cash.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("ATM is out of cash.");
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("ATM is out of cash.");
    }
}
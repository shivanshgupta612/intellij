package LowLevelDesign.DesignPatterns.StateDesignPattern.ATM;

// Concrete state for when the ATM is idle
class IdleState implements State {
    private ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card inserted.");
        atm.setState(atm.getHasCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Insert card first.");
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Insert card first.");
    }
}




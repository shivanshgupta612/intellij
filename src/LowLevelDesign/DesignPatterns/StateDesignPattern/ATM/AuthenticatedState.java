package LowLevelDesign.DesignPatterns.StateDesignPattern.ATM;

class AuthenticatedState implements State {
    private ATM atm;

    public AuthenticatedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card is already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setState(atm.getIdleState());
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Already authenticated.");
    }

    @Override
    public void requestCash(int amount) {
        if (amount <= atm.getCashInMachine()) {
            System.out.println("Cash dispensed: $" + amount);
            atm.setCashInMachine(atm.getCashInMachine() - amount);
            if (atm.getCashInMachine() <= 0) {
                atm.setState(atm.getOutOfCashState());
            }
        } else {
            System.out.println("Insufficient cash in the machine.");
        }
    }
}

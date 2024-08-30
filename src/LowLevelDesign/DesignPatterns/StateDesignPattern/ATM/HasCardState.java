package LowLevelDesign.DesignPatterns.StateDesignPattern.ATM;

// Concrete state for when a card is inserted
class HasCardState implements State {
    private ATM atm;

    public HasCardState(ATM atm) {
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
        if (pin == 1234) { // Hardcoded PIN for simplicity
            System.out.println("PIN accepted.");
            atm.setState(atm.getAuthenticatedState());
        } else {
            System.out.println("Invalid PIN.");
            atm.ejectCard();
        }
    }

    @Override
    public void requestCash(int amount) {
        System.out.println("Enter PIN first.");
    }
}

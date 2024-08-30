package LowLevelDesign.DesignPatterns.StateDesignPattern.ATM;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(100);

        atm.insertCard(); // Card inserted
        atm.enterPin(1234); // PIN accepted
        atm.requestCash(50); // Cash dispensed


        atm.insertCard(); // Card is already inserted
        atm.enterPin(1234); // Already authenticated
        atm.requestCash(60); // Insufficient cash in the machine

        atm.insertCard(); // ATM is out of cash
    }
}

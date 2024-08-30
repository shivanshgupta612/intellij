package LowLevelDesign.DesignPatterns.StateDesignPattern.TV;

class MutedState implements State {
    private TV tv;

    public MutedState(TV tv) {
        this.tv = tv;
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Turning TV off.");
        tv.setCurrentState(tv.getOffState());
    }

    @Override
    public void pressVolumeButton() {
        System.out.println("Unmuting and adjusting volume.");
        tv.setCurrentState(tv.getOnState());
    }

    @Override
    public void pressMuteButton() {
        System.out.println("Unmuting TV.");
        tv.setCurrentState(tv.getOnState());
    }
}

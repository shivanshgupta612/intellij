package LowLevelDesign.DesignPatterns.StateDesignPattern.TV;

class OffState implements State {
    private TV tv;

    public OffState(TV tv) {
        this.tv = tv;
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Turning TV on.");
        tv.setCurrentState(tv.getOnState());
    }

    @Override
    public void pressVolumeButton() {
        System.out.println("TV is off. Turn it on first.");
    }

    @Override
    public void pressMuteButton() {
        System.out.println("TV is off. Turn it on first.");
    }
}
package LowLevelDesign.DesignPatterns.StateDesignPattern.TV;

class OnState implements State {
    private TV tv;

    public OnState(TV tv) {
        this.tv = tv;
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Turning TV off.");
        tv.setCurrentState(tv.getOffState());
    }

    @Override
    public void pressVolumeButton() {
        System.out.println("Adjusting volume.");
    }

    @Override
    public void pressMuteButton() {
        System.out.println("Muting TV.");
        tv.setCurrentState(tv.getMutedState());
    }
}

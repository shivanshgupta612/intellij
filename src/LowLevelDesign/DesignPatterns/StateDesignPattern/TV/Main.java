package LowLevelDesign.DesignPatterns.StateDesignPattern.TV;

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();

        tv.pressPowerButton(); // Turning TV on
        tv.pressVolumeButton(); // Adjusting volume
        tv.pressMuteButton(); // Muting TV

        tv.pressMuteButton(); // Unmuting TV
        tv.pressVolumeButton(); // Adjusting volume

        tv.pressPowerButton(); // Turning TV off
        tv.pressVolumeButton(); // TV is off. Turn it on first.
    }
}

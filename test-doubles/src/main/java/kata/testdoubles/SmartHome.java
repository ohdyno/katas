package kata.testdoubles;

public class SmartHome {
    private final Switchable switchable;
    private final Switch aSwitch;

    public SmartHome(Switchable switchable, Switch aSwitch) {
        this.switchable = switchable;
        this.aSwitch = aSwitch;
    }

    public void run() {
        while (true) {
            runOnce();
        }
    }

    void runOnce() {
        if (aSwitch.isOn()) {
            switchable.turnOn();
        } else {
            switchable.turnOff();
        }
    }
}

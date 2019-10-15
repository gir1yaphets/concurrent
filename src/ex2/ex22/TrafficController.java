package ex2.ex22;

public class TrafficController {
    private volatile boolean hasCarOnBridge = false;

    public synchronized void enterLeft() {
        while (true) {
            if (!hasCarOnBridge) {
                break;
            }
        }

        hasCarOnBridge = true;
    }

    public synchronized void enterRight() {
        while (true) {
            if (!hasCarOnBridge) {
                break;
            }
        }

        hasCarOnBridge = true;
    }

    public void leaveLeft() {
        hasCarOnBridge = false;
    }

    public void leaveRight() {
        hasCarOnBridge = false;
    }

}
package ex2.ex22;

public class TrafficController {
    private volatile boolean isLeftCarOnBridge = false;
    private volatile boolean isRightCarOnBridge = false;

    public synchronized void enterLeft() {
        while (true) {
            if (!isRightCarOnBridge) {
                break;
            }
        }

        isLeftCarOnBridge = true;
    }

    public synchronized void enterRight() {
        while (true) {
            if (!isLeftCarOnBridge) {
                break;
            }
        }

        isRightCarOnBridge = true;
    }

    public void leaveLeft() {
        isRightCarOnBridge = false;
    }

    public void leaveRight() {
        isLeftCarOnBridge = false;
    }

}
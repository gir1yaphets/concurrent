package ex2.ex22;

public class TrafficController {
    private volatile boolean hasCarOnBridge = false;

    public void enterLeft() {
        crossBridge();
    }

    public void enterRight() {
        crossBridge();
    }

    public void leaveLeft() {
        hasCarOnBridge = false;
    }

    public void leaveRight() {
        hasCarOnBridge = false;
    }

    private synchronized void crossBridge() {
        while (true) {
            if (!hasCarOnBridge) {
                break;
            }
        }

        hasCarOnBridge = true;
    }

}
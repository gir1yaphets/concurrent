package ex3.ex33;

public class MessageQueue {
    private static int n_ids;

    public static void main(String[] args) {
	???queue = new ???(10);
        Producer p1 = new Producer(queue, n_ids++);
        Consumer c1 = new Consumer(queue, n_ids++);

        new Thread(p1).start();
        new Thread(c1).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p1.stop();
    }
}

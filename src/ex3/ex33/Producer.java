package ex3.ex33;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
    private LinkedBlockingQueue<Message> queue;
    private boolean running = true;
    private int id;

    public Producer(LinkedBlockingQueue<Message> q, int n) {
        queue = q;
        id = n;
    }

    public void stop() {
        running = false;
    }

    public void run() {
        int count = 0;
        while (running) {
            int n = RandomUtils.randomInteger();
            try {
                Thread.sleep(n);
                Message msg = new Message("message-" + n);
		        queue.put(msg); // Put the message in the queue
                count++;
                RandomUtils.print("Produced " + msg.get(), id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Put the stop message in the queue
        Message msg = new Message("stop");
        try {
	        queue.put(msg); // Put this final message in the queue
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RandomUtils.print("Messages sent: " + count, id);
    }
}

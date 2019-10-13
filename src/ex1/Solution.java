package ex1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private List<Thread> threadList = new LinkedList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Command:");

        while (true) {
            String cmd = sc.nextLine();

            if ("a".equals(cmd)) {
                Thread thread = solution.createThread();
                thread.start();
            } else if ("c".equals(cmd)) {
                solution.stopAll();
                break;
            } else if (cmd.contains("b")) {
                int threadId = cmd.charAt(cmd.length() - 1) - '0';

                solution.stopOne(threadId);
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private Thread createThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                long id = Thread.currentThread().getId();
                System.out.println("Hello World! I'm thread " + id + ". The time is " + System.currentTimeMillis());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadList.add(thread);

        return thread;
    }

    private void stopOne(int i) {
        if (i < threadList.size()) {
            threadList.get(i).stop();
        }
    }

    private void stopAll() {
        for (Thread t : threadList) {
            t.stop();
        }
    }
}

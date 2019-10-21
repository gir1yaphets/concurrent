package ex3.ex34;

import java.util.concurrent.Semaphore;

public class Main3 {

    private static Semaphore semaphore = new Semaphore(1);

    private static void nap(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addProc(HighLevelDisplay d) {

        // Add a sequence of addRow operations with short random naps.
        for (int i = 0; i < 20; i++) {
            try {
                semaphore.acquire();
                d.addRow("AAAAAAAAAAAA  " + i);
                d.addRow("BBBBBBBBBBBB  " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }

            nap(500);
        }
    }

    private static void deleteProc(HighLevelDisplay d) {

        // Add a sequence of deletions of row 0 with short random naps.
        for (int i = 0; i < 20; i++) {
            try {
                semaphore.acquire();
                d.deleteRow(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }

            nap(1000);
        }
    }

    public static void main(String[] args) {
        final HighLevelDisplay d = new JDisplay2();

        new Thread() {
            public void run() {
                addProc(d);
            }
        }.start();


        new Thread() {
            public void run() {
                deleteProc(d);
            }
        }.start();

    }
}
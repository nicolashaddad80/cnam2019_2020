package fr.cnam.smb111.mytrainings.synchronisation;

public class TestInterruptingThread1StopOnException extends Thread {
    public static void main(String[] args) {
        TestInterruptingThread1StopOnException t1 = new TestInterruptingThread1StopOnException();
        t1.start();
        try {
            t1.interrupt();
        } catch (Exception e) {
            System.out.println("Exception handled " + e);
        }

    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("task");
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread interrupted..." + e);
        }

    }
}
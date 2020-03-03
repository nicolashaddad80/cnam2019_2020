package fr.cnam.smb111.mytrainings.synchronisation;

public class TestInterruptingThread2InterruptExceptionHandled extends Thread {
    public static void main(String[] args) {
        TestInterruptingThread2InterruptExceptionHandled t1 = new TestInterruptingThread2InterruptExceptionHandled();
        t1.start();

        t1.interrupt();

    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("task");
        } catch (InterruptedException e) {
            System.out.println("Exception handled " + e);
        }
        System.out.println("thread is running...");
    }
}
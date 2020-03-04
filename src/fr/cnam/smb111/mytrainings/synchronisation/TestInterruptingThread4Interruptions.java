package fr.cnam.smb111.mytrainings.synchronisation;

public class TestInterruptingThread4Interruptions extends Thread {

    public static void main(String[] args) {

        TestInterruptingThread4Interruptions t1 = new TestInterruptingThread4Interruptions();
        TestInterruptingThread4Interruptions t2 = new TestInterruptingThread4Interruptions();

        t1.start();
        t1.interrupt();

        t2.start();

    }

    public void run() {
        for (int i = 1; i <= 2; i++) {
            if (Thread.interrupted()) {
                System.out.println("code for interrupted thread");
            } else {
                System.out.println("code for normal thread");
            }

        }//end of for loop
    }
}
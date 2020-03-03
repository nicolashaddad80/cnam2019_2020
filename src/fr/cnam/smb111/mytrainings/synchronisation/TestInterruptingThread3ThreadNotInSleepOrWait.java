package fr.cnam.smb111.mytrainings.synchronisation;

public class TestInterruptingThread3ThreadNotInSleepOrWait extends Thread {

    public static void main(String[] args) {
        TestInterruptingThread3ThreadNotInSleepOrWait t1 = new TestInterruptingThread3ThreadNotInSleepOrWait();
        t1.start();

        t1.interrupt();

    }

    public void run() {
        for (int i = 1; i <= 5; i++)
            System.out.println(i);
    }
}

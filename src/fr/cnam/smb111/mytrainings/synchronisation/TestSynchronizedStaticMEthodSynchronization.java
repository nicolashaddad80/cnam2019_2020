package fr.cnam.smb111.mytrainings.synchronisation;

public class TestSynchronizedStaticMEthodSynchronization {
    public static void main(String[] args) {

        Thread t1 = new Thread() {
            public void run() {
                StaticMethodSynchronizedTable.printTable(1);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                StaticMethodSynchronizedTable.printTable(10);
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                StaticMethodSynchronizedTable.printTable(100);
            }
        };

        Thread t4 = new Thread() {
            public void run() {
                StaticMethodSynchronizedTable.printTable(1000);
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

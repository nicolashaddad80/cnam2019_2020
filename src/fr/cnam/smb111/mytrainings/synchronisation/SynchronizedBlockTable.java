package fr.cnam.smb111.mytrainings.synchronisation;

public class SynchronizedBlockTable extends Table {


    public void printTable(int n) {
        synchronized (this) {//synchronized block
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }//End Synchronized Block
    }
}

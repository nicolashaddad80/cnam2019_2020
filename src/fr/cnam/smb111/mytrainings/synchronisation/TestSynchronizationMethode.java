package fr.cnam.smb111.mytrainings.synchronisation;

public class TestSynchronizationMethode {
    public static void main(String[] args) {
        SynchronizedMethodeTable obj = new SynchronizedMethodeTable();//only one object
        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);
        t1.start();
        t2.start();
    }
}
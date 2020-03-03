package fr.cnam.smb111.mytrainings.synchronisation;

public class Reentrant {
    public synchronized void m() {
        n();
        System.out.println("this is m() method");
    }

    public synchronized void n() {
        System.out.println("this is n() method");
    }
}
package fr.cnam.smb111.mytrainings.synchronisation;

public class CustomerWait {
    int amount = 10000;

    public static void main(String[] args) {
        final CustomerWait c = new CustomerWait();
        new Thread() {
            public void run() {
                c.withdraw(15000);
            }
        }.start();
        new Thread() {
            public void run() {
                c.deposit(10000);
            }
        }.start();

    }

    synchronized void withdraw(int amount) {
        System.out.println("going to withdraw...");

        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.amount -= amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount) {
        System.out.println("going to deposit...");
        this.amount += amount;
        System.out.println("deposit completed...  Notifying Other Threads that waits on Amount");

        notify();
    }
}



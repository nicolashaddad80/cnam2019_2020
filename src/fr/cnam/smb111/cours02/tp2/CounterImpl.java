package fr.cnam.smb111.cours02.tp2;


public class CounterImpl implements Counter{
    private int count=0;
    @Override
    public  synchronized void increment() {

            this.count++;

    }

    @Override
    public synchronized void decrement() {
        this.count--;
        if(Debug.COUNTER_DEBUG_ON) System.out.println("New Counter Value is: " + this.count);
    }

    @Override
    public  synchronized int getValue() {
        return this.count;
    }
}

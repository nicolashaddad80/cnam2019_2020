package fr.cnam.smb111.cours02.tp2;


public class CounterImpl implements Counter {
    private int count = 0;

    @Override
    public void increment() {
        this.count++;
        if (Debug.COUNTER_DEBUG_ON) System.out.println("New Counter Value is: " + this.count);
    }

    @Override
    public void decrement() {
        this.count--;
        if (Debug.COUNTER_DEBUG_ON) System.out.println("New Counter Value is: " + this.count);
    }

    @Override
    public int getValue() {
        return this.count;
    }
}

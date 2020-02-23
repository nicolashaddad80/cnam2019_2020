package fr.cnam.nfp121.cours11.model;

import fr.cnam.cour11.DebugOnOFF;
import fr.cnam.nfp121.cours11.mydesignpatterns.observer.MyObservableImp1;

public class CounterImp1 extends MyObservableImp1 implements Counter {

    private int value = 0;

    @Override
    public void increment() {
        this.value++;
        if (DebugOnOFF.DEBUG_ON) System.out.println("Value Incremented");
        this.notifyObservers();
    }

    @Override
    public void reset() {
        this.value = 0;
        if (DebugOnOFF.DEBUG_ON) System.out.println("Value Reseated");
        this.notifyObservers();
    }

    @Override
    public int getValue() {
        if (DebugOnOFF.DEBUG_ON) System.out.println("get Value Invoked");
        return this.value;
    }
}


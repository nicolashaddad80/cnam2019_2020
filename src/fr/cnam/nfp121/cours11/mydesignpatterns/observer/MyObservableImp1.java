package fr.cnam.nfp121.cours11.mydesignpatterns.observer;

import fr.cnam.cour11.DebugOnOFF;

import java.util.ArrayList;


public class MyObservableImp1 implements MyObservable {

    private ArrayList<MyObserver> observers;

    public MyObservableImp1() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(MyObserver a_My_observer) {
        this.observers.add(a_My_observer);
        if (DebugOnOFF.DEBUG_ON)
            System.out.println("An Observer just registered, now total Observers= " + this.countObservers());
    }

    @Override
    public void unregisterObserver(MyObserver a_My_observer) {
        this.observers.remove(a_My_observer);
        if (DebugOnOFF.DEBUG_ON)
            System.out.println("An Observer just Unregistered, now total Observers= " + this.countObservers());
    }

    @Override
    public void notifyObservers() {
        if (DebugOnOFF.DEBUG_ON) System.out.println("notifying " + this.countObservers() + ": All Observers");
        for (MyObserver obs : this.observers) {
            obs.notifyMe();
        }
    }

    @Override
    public int countObservers() {
        return this.observers.size();
    }
}

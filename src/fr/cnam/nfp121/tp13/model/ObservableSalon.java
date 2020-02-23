package fr.cnam.nfp121.tp13.model;


import fr.cnam.nfp121.tp12.mypatterns.MyObservable;
import fr.cnam.nfp121.tp12.mypatterns.MyObserver;
import fr.cnam.nfp121.tp13.DebugOnOFF;

import java.util.ArrayList;
import java.util.TreeSet;

public class ObservableSalon extends TreeSet<String> implements MyObservable {


    private ArrayList<MyObserver> observers = new ArrayList<>();

    @Override
    public boolean add(String a_message) {

        boolean success = super.add(a_message);
        this.notifyObservers();
        return success;
    }

    @Override
    public void addObserver(MyObserver a_My_observer) {
        this.observers.add(a_My_observer);
        if (DebugOnOFF.DEBUG_ON)
            System.out.println("An Observer just registered, now total Observers= " + this.countObservers());
    }

    @Override
    public void deleteObserver(MyObserver a_My_observer) {
        this.observers.remove(a_My_observer);
        if (DebugOnOFF.DEBUG_ON)
            System.out.println("An Observer just Unregistered, now total Observers= " + this.countObservers());
    }

    @Override
    public void notifyObservers() {
        if (DebugOnOFF.DEBUG_ON) System.out.println("notifying " + this.countObservers() + ": All Observers");
        for (MyObserver obs : this.observers) {
            obs.update(this);
        }
    }

    @Override
    public int countObservers() {
        return this.observers.size();
    }


}


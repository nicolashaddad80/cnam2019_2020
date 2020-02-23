package fr.cnam.nfp121.cours11.model;

import fr.cnam.nfp121.cours11.mydesignpatterns.observer.MyObservable;

public interface Counter extends MyObservable {

    void increment();

    void reset();

    int getValue();
}

package fr.cnam.nfp121.cours11.mydesignpatterns.observer;

public interface MyObservable {
    void registerObserver(MyObserver a_My_observer);

    void unregisterObserver(MyObserver a_My_observer);

    void notifyObservers();

    int countObservers();
}

package fr.cnam.nfp121.tp12.point;


import fr.cnam.nfp121.tp12.mypatterns.MyObservable;
import fr.cnam.nfp121.tp12.mypatterns.MyObserver;

import java.util.ArrayList;
import java.util.List;

public class PointObservable extends PointImpl implements MyObservable {

    private List<MyObserver> observers;

    public PointObservable(Point point) {
        super(point.getX(), point.getY());
        this.observers = new ArrayList<>();
    }

    @Override
    public void translate(double a_x, double a_y) {
        super.translate(a_x, a_y);
        this.notifyObservers();
    }

    @Override
    public void addObserver(MyObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void deleteObserver(MyObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public int countObservers() {
        return this.observers.size();
    }

    @Override
    public void notifyObservers() {

        for (MyObserver observer : this.observers) {
            observer.update(this);
        }
    }
}

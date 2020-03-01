package fr.cnam.nfp121.tp12.segment;


import fr.cnam.nfp121.tp12.mypatterns.MyObserver;

public interface Segment extends MyObserver {

    double getLength();

    void translate(double dx, double dy);

}

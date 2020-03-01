package fr.cnam.nfp121.tp12.circle;

import fr.cnam.nfp121.tp12.mypatterns.MyObserver;
import fr.cnam.nfp121.tp12.point.Point;

public interface Circle extends MyObserver {
    Point getCenter();

    double getRadius();
}

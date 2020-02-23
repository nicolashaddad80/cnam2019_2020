package fr.cnam.nfp121.tp12.point;


public interface Point {
    double getX();

    double getY();

    double distance(Point other);

    void translate(double dx, double dy);


}

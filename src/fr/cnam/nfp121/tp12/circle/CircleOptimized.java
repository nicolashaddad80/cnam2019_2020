package fr.cnam.nfp121.tp12.circle;


import fr.cnam.nfp121.tp12.point.PointObservable;


public class CircleOptimized implements Circle {

    /**
     * Attributes
     */

    private PointObservable centerPoint;
    private PointObservable circonfPoint;


    /**
     * Le Rayon de Notre Cercle
     */
    private double radius;


    /**
     * Constructor
     */
    public CircleOptimized(PointObservable centerPoint, PointObservable circonfPoint) {

        this.centerPoint = centerPoint;
        this.centerPoint.addObserver(this);

        this.circonfPoint = circonfPoint;
        this.circonfPoint.addObserver(this);

        this.updateRadius();
    }

    private void translateCenter() {
        this.circonfPoint.translate(this.centerPoint.getX(), this.centerPoint.getY());
    }

    private void updateRadius() {
        this.radius = this.circonfPoint.distance(this.centerPoint);
    }


    @Override
    public PointObservable getCenter() {
        return this.centerPoint;
    }

    /**
     * Methode pour obtenir le Rayon de notre Cercle
     *
     * @return le Rayon de notre Cercle
     */
    @Override
    public double getRadius() {
        return this.radius;
    }


    @Override
    public void destroy() {
        this.centerPoint.deleteObserver(this);
        this.circonfPoint.deleteObserver(this);
    }

    @Override
    public void update(Object observable) {
        if(observable==this.centerPoint) this.translateCenter();
        if(observable==this.circonfPoint) this.updateRadius();
    }

}

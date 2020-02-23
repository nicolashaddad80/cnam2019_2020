package fr.cnam.nfp121.tp12.point;


public class PointImpl implements Point {
    /**
     * L'Abscisse de notre Point
     */
    protected double x;

    /**
     * L'Ordonnee de notre Point
     */
    protected double y;

    /**
     * Le constructeur de notre Point
     *
     * @param a_x : L'Abscisse de notre Point
     * @param a_y : L'Ordonnee de notre Point
     */
    public PointImpl(double a_x, double a_y) {
        this.x = a_x;
        this.y = a_y;
    }


    /**
     * Pour obtenir l'Abscisse de Notre Point
     *
     * @return : L'Abscisse de notre Point
     */
    @Override
    public double getX() {
        return this.x;
    }


    /**
     * Pour obtenir l'Ordonnee de Notre Point
     *
     * @return : L'Ordonnee de notre Point
     */
    @Override
    public double getY() {
        return this.y;
    }


    /**
     * Permet de calculer la distance separant notre point  par rapport a un autre Point de reference
     *
     * @param a_p : le point de reference
     * @return : la distance entre notre Point  et le Point de reference
     */
    @Override
    public double distance(Point a_p) {
        return (Math.sqrt((a_p.getX() - this.x) * (a_p.getX() - this.x) + (a_p.getY() - this.y) * (a_p.getY() - this.y)));
    }


    /**
     * Pour appliquer une translation a notre Point
     *
     * @param a_x : le deplacement a appliquer selon l'axe de Abscisses
     * @param a_y : le deplacement a appliquer selon l'axe des Ordonnees
     */
    @Override
    public void translate(double a_x, double a_y) {
        this.x = this.x + a_x;
        this.y = this.y + a_y;
    }
}

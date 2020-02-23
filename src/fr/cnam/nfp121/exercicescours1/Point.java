package fr.cnam.nfp121.exercicescours1;

public class Point {

    /**
     * L'abscisse de notre Point
     */
    public double x;

    /**
     * L'ordonnee de notre point
     */
    public double y;


    public Point(double a_adscisse, double a_ordonnee) {
        this.x = a_adscisse;
        this.y = a_ordonnee;

    }

    public static void main(String[] args) {

        Point p1 = new Point(5, 8);
        System.out.println("p1=" + p1);
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
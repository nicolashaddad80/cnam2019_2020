package fr.cnam.nfp121.tp1and2;


public class TestPointBis {

    public static void main(String[] args) {

        Point p1;
        p1 = new Point(1, 0);
        p1.setX(10);
        System.out.println("P1=" + p1);
        System.out.println("Module de p1=" + p1.getMod());
    }
}

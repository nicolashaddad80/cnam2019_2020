package fr.cnam.nfp121.tp1and2;

public class TestPoint {

    public static void main(String[] args) {

        Point p1;
        p1 = new Point(1, 0);
        System.out.println("p1 before translation=" + p1);
        p1.translate(-1, 1);
        System.out.println("p1 after translation=" + p1);
    }
}

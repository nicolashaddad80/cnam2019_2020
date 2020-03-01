package fr.cnam.nfp121.tp7;

import org.junit.Before;
import org.junit.Test;


public class IsEqualTest {

    private NamedPoint np1, np2, np3, np4, np5;
    private Point p1, p2, p3, q1, q2, q3;

    @Before
    public void setUp() {
        this.np1 = new NamedPoint(1, 2, "A");
        this.np2 = new NamedPoint(1, 2, "A");
        this.np3 = new NamedPoint(1, 2, "B");
        this.np4 = new NamedPoint(1, 1, "A");
        this.np5 = new NamedPoint(1, 1, "B");

        this.p1 = new Point(1, 1);
        this.p2 = new Point(1, 1);

        this.q3 = new NamedPoint(1, 1, "A");
        p3 = p2;
        q1 = np4;
        q2 = np5;
    }

    @Test
    public void test1() {

        if (this.p1 == this.p2) {
            System.out.println("Operateur == : p1 est egale a p2");
        } else {
            System.out.println("Operateur == : p1 est different de p2");
        }

        if (this.p2 == this.p3) {
            System.out.println("Operateur == : p2 est egale a p3");
        } else {
            System.out.println("Operateur == : p2 est different de p3");
        }


        if (this.p1.isEqual(this.p2)) {
            System.out.println("Methode isEqual : p1 est egale a p2");
        } else {
            System.out.println("Methode isEqual : p1 est different de p2");
        }

        if (this.p1.isEqual(this.np4)) {
            System.out.println("Methode isEqual : p1 est egale a np4");
        } else {
            System.out.println("Methode isEqual : p1 est different de np4");
        }

        if (this.np1.isEqual(this.np3)) {
            System.out.println("Methode isEqual : np1 est egale a np3");
        } else {
            System.out.println("Methode isEqual : np1 est different de np3");
        }


    }

    @Test
    public void test2() {
        if (this.q1.isEqual(this.p1)) {
            System.out.println("Methode isEqual : q1 est egale a p1");
        } else {
            System.out.println("Methode isEqual : q1 est different de p1");
        }

        if (this.np4.isEqual(this.p1)) {
            System.out.println("Methode isEqual : np4 est egale a p1");
        } else {
            System.out.println("Methode isEqual : np4 est different de p1");
        }

    }

    @Test
    public void test3() {
        if (this.np4.isEqual(this.q3)) {
            System.out.println("Methode isEqual : np4 est egale a q3");
        } else {
            System.out.println("Methode isEqual : np4 est different de q3");
        }
    }

    @Test
    public void test4() {
        if (this.np4.isEqual(this.np5)) {
            System.out.println("Methode isEqual : np4 est egale a np5");
        } else {
            System.out.println("Methode isEqual : np4 est different de np5");
        }

        if (this.q1.isEqual(this.np5)) {
            System.out.println("Methode isEqual : q1 est egale a np5");
        } else {
            System.out.println("Methode isEqual : q1 est different de np5");
        }

        if (this.q1.isEqual(this.q2)) {
            System.out.println("Methode isEqual : q1 est egale a q2");
        } else {
            System.out.println("Methode isEqual : q1 est different de q2");
        }
    }

    @Test
    public void test5() {
        if (this.p1.isEqual(this.np4)) {
            System.out.println("Methode isEqual : p1 est egale a np4");
        } else {
            System.out.println("Methode isEqual : p1 est different de np4");
        }

        if (this.np4.isEqual(this.p1)) {
            System.out.println("Methode isEqual : np4 est egale a p1");
        } else {
            System.out.println("Methode isEqual : np4 est different de p1");
        }

        if (this.q1.isEqual(this.q2)) {
            System.out.println("Methode isEqual : q1 est egale a q2");
        } else {
            System.out.println("Methode isEqual : q1 est different de q2");
        }
    }
}

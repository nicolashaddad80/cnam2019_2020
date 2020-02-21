package fr.cnam.tp1and2.tests;

import fr.cnam.tp1and2.point.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    public static final double e = 1e-6;

    private Point point1;
    private Point point2;

    @Before
    public void setUp() {
        this.point1 = new Point(1, 2);
        this.point2 = new Point(4, -2);
    }

    @Test
    public void testInitialisation() {
        assertNotNull(this.point1);
        assertNotNull(this.point2);
        assertEquals(1, this.point1.getX(), e);
        assertEquals(2, this.point1.getY(), e);
        assertEquals(4, this.point2.getX(), e);
        assertEquals(-2, this.point2.getY(), e);
    }

    @Test
    public void testSetX() {
        this.point1.setX(10);
        assertEquals(10, this.point1.getX(), e);
        this.point1.setX(-5);
        assertEquals(-5, this.point1.getX(), e);
    }

    @Test
    public void testSetY() {
        this.point1.setY(10);
        assertEquals(10, this.point1.getY(), e);
        this.point1.setY(-5);
        assertEquals(-5, this.point1.getY(), e);
    }

    @Test
    public void testDistance() {
        assertEquals(0, this.point1.distance(this.point1), e);
        assertEquals(0, this.point2.distance(this.point2), e);
        assertEquals(5, this.point1.distance(this.point2), e);
        assertEquals(5, this.point2.distance(this.point1), e);
    }

    @Test
    public void testTranslate1() {
        this.point1.translate(2, 4);
        assertEquals(3, this.point1.getX(), e);
        assertEquals(6, this.point1.getY(), e);
    }

    @Test
    public void testTranslate2() {
        this.point2.translate(-2, -4);
        assertEquals(2, this.point2.getX(), e);
        assertEquals(-6, this.point2.getY(), e);
    }
}
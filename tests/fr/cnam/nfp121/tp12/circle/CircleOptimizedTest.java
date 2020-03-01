package fr.cnam.nfp121.tp12.circle;

import fr.cnam.nfp121.tp12.mypatterns.MyObserver;
import fr.cnam.nfp121.tp12.point.PointImpl;
import fr.cnam.nfp121.tp12.point.PointObservable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleOptimizedTest {
    private final static double e = Double.MIN_VALUE;

    @Test
    public void test1() {
        PointObservable center = new PointObservable(new PointImpl(0, 0));
        PointObservable point = new PointObservable(new PointImpl(5, 0));
        Circle circle = new CircleOptimized(center, point);
        assertEquals(5, circle.getRadius(), e);

        center.translate(0, 5);
        assertEquals(0, circle.getCenter().getX(), e);
        assertEquals(5, circle.getCenter().getY(), e);
        assertEquals(5, point.getX(), e);
        assertEquals(5, point.getY(), e);
        assertEquals(5, circle.getRadius(), e);

        point.translate(5, 0);
        assertEquals(0, circle.getCenter().getX(), e);
        assertEquals(5, circle.getCenter().getY(), e);
        assertEquals(10, point.getX(), e);
        assertEquals(5, point.getY(), e);
        assertEquals(10, circle.getRadius(), e);
    }

    @Test
    public void test2() {
        PointObservable center = new PointObservable(new PointImpl(1, 2));

        for (int i = 0; i < 100; i++) {
            MyObserver c = new CircleOptimized(center, new PointObservable(new PointImpl(i, i)));
            c.destroy();
        }

        assertEquals(0, center.countObservers());
    }
}

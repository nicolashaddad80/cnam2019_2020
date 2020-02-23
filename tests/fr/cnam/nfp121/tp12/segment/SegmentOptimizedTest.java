package fr.cnam.nfp121.tp12.segment;

import fr.cnam.nfp121.tp12.mypatterns.MyObserver;
import fr.cnam.nfp121.tp12.point.PointImpl;
import fr.cnam.nfp121.tp12.point.PointObservable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SegmentOptimizedTest {
    private final static double e = Double.MIN_VALUE;

    @Test
    public void test1() {
        PointObservable p1 = new PointObservable(new PointImpl(0, 0));
        PointObservable p2 = new PointObservable(new PointImpl(5, 0));
        Segment s = new SegmentOptimized(p1, p2);
        assertEquals(5, s.getLength(), e);

        p2.translate(-2, 0);
        assertEquals(3, s.getLength(), e);
    }

    @Test
    public void test2() {
        PointObservable p1 = new PointObservable(new PointImpl(0, 0));
        PointObservable p2 = new PointObservable(new PointImpl(5, 0));
        PointObservable p3 = new PointObservable(new PointImpl(10, 0));
        Segment s1 = new SegmentOptimized(p1, p2);
        Segment s2 = new SegmentOptimized(p2, p3);
        assertEquals(5, s1.getLength(), e);
        assertEquals(5, s2.getLength(), e);

        p2.translate(-2, 0);
        assertEquals(3, s1.getLength(), e);
        assertEquals(7, s2.getLength(), e);
    }

    @Test
    public void test3() {
        PointObservable p1 = new PointObservable(new PointImpl(1, 2));

        for (int i = 0; i < 100; i++) {
            MyObserver s = new SegmentOptimized(new PointObservable(new PointImpl(i, i)), p1);
            s.destroy();
        }

        assertEquals(0, p1.countObservers());
    }

    @Test
    public void test4() {
        PointObservable p1 = new PointObservable(new PointImpl(0, 0));
        PointObservable p2 = new PointObservable(new PointImpl(5, 0));
        PointObservable p3 = new PointObservable(new PointImpl(10, 0));
        Segment s1 = new SegmentOptimized(p1, p2);
        Segment s2 = new SegmentOptimized(p2, p3);
        assertEquals(5, s1.getLength(), e);
        assertEquals(5, s2.getLength(), e);

        s1.translate(-2, 0);
        assertEquals(5, s1.getLength(), e);
        assertEquals(7, s2.getLength(), e);
    }
}

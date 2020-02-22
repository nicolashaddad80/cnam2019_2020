package fr.cnam.nfp121.tp6;

import fr.cnam.tp6.History;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HistoryTest {
    private final static double e = 0.0001;
    private History hist0;

    @Before
    public void setUp() {
        this.hist0 = new History();
    }

    @Test
    public void testInitialisation() {
        assertNotNull(this.hist0);
        assertNotNull(this.hist0.getCredit());
        assertNotNull(this.hist0.getDebit());
        assertEquals(0, this.hist0.getNbOperation());
        assertEquals(0, this.hist0.getCredit().getNbOperation());
        assertEquals(0, this.hist0.getDebit().getNbOperation());
    }

    @Test
    public void testAjoutOperation() {
        this.hist0.addOperation(10);
        this.hist0.addOperation(20);
        this.hist0.addOperation(30);
        this.hist0.addOperation(-10);
        this.hist0.addOperation(-20);

        assertEquals(5, this.hist0.getNbOperation());
        assertEquals(20, this.hist0.getOperation(2), e);
        assertEquals(-20, this.hist0.getOperation(5), e);

        assertEquals(3, this.hist0.getCredit().getNbOperation());
        assertEquals(10, this.hist0.getCredit().getOperation(1), e);

        assertEquals(2, this.hist0.getDebit().getNbOperation());
        assertEquals(-10, this.hist0.getDebit().getOperation(1), e);
    }

    @Test
    public void testAffichage() {
        assertEquals("[\n]", this.hist0.toString());
        assertEquals("[\n]", this.hist0.getDebit().toString());
        assertEquals("[\n]", this.hist0.getCredit().toString());

        this.hist0.addOperation(10);
        this.hist0.addOperation(-20);

        assertEquals("[\n1, 10.0\n2, -20.0\n]", this.hist0.toString());
        assertEquals("[\n1, -20.0\n]", this.hist0.getDebit().toString());
        assertEquals("[\n1, 10.0\n]", this.hist0.getCredit().toString());

    }

    @Test
    public void getOperation() {
        this.hist0.addOperation(10);
        this.hist0.addOperation(-20);

        assertEquals(10, this.hist0.getOperation(1), e);
        assertEquals(-20, this.hist0.getOperation(2), e);
    }

    @Test(expected = java.lang.AssertionError.class)
    public void getOperationIllegal1() {
        this.hist0.addOperation(10);
        this.hist0.addOperation(-20);
        this.hist0.getOperation(3);
    }

    @Test(expected = java.lang.AssertionError.class)
    public void getOperationIllegal2() {
        this.hist0.getOperation(1);
    }

    @Test(expected = java.lang.AssertionError.class)
    public void getOperationIllegal3() {
        this.hist0.addOperation(10);
        this.hist0.addOperation(-20);
        this.hist0.getOperation(0);
    }

    @Test(expected = java.lang.AssertionError.class)
    public void getOperationIllegal4() {
        this.hist0.addOperation(10);
        this.hist0.addOperation(-20);
        this.hist0.getOperation(-1);
    }

}

package fr.cnam.nfp121.tp6;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SimpleAccountTest {

    protected final double e = 0.0001;
    protected SimpleAccount acc1;
    private String nom = "HADDAD";
    private String prenom = "Nicolas";
    private Gender genre = Gender.MALE;
    protected Person p0 = new Person(this.nom, this.prenom, this.genre);

    @Before
    public void setUp() {

        this.acc1 = new SimpleAccount(this.p0);
    }

    @Test
    public void testInitialisation() {
        assertNotNull(this.p0);
        assertNotNull(this.acc1);
        assertEquals(this.p0, this.acc1.getOwner());
        assertEquals(0, this.acc1.getAmount(), e);
    }

    @Test
    public void testCredit() {
        this.acc1.credit(60);
        assertEquals(60, this.acc1.getAmount(), e);
    }

    @Test
    public void testDebit() {
        this.acc1.credit(60);
        this.acc1.debit(25);
        assertEquals(35, this.acc1.getAmount(), e);
    }

    @Test
    public void testToString() {
        assertEquals("[(HADDAD, Nicolas, MALE), 0.0]", this.acc1.toString());
    }
}

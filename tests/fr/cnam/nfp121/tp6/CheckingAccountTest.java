package fr.cnam.nfp121.tp6;

import fr.cnam.tp6.CheckingAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckingAccountTest extends SimpleAccountTest {
    private void executeOrders() {
        this.acc1.credit(60);
        this.acc1.debit(20);
        this.acc1.credit(100);
        this.acc1.debit(50);
    }

    @Override
    @Before
    public void setUp() {
        this.acc1 = new CheckingAccount(this.p0);
    }


    @Test
    public void getAccountStatement() {
        executeOrders();
        assertEquals("[\n1, 60.0\n2, -20.0\n3, 100.0\n4, -50.0\n]", ((CheckingAccount) this.acc1).getAccountStatement());
    }

    @Test
    public void getCreditStatement() {
        executeOrders();
        assertEquals("[\n1, 60.0\n2, 100.0\n]", ((CheckingAccount) this.acc1).getCreditStatement());
    }

    @Test
    public void getDebitStatement() {
        executeOrders();
        assertEquals("[\n1, -20.0\n2, -50.0\n]", ((CheckingAccount) this.acc1).getDebitStatement());
    }
}
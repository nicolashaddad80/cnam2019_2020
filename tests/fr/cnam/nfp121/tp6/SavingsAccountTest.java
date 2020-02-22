package fr.cnam.nfp121.tp6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest extends CheckingAccountTest {

    @Override
    @Before
    public void setUp() {
        this.acc1 = new SavingsAccount(this.p0);
    }

    @Test(expected = java.lang.AssertionError.class)
    public void creditExeedsMaxAmount() {
        this.acc1.credit(22950);
        this.acc1.credit(0.01);
        Assert.assertEquals(22950, this.acc1.getAmount(), e);
    }

    @Test(expected = java.lang.AssertionError.class)
    public void debitExeedsAmount() {
        this.acc1.credit(1000);
        this.acc1.debit(1000.01);
        Assert.assertEquals(1000, this.acc1.getAmount(), e);
    }

    @Test
    public void applyInterest1() {
        this.acc1.credit(1000);
        ((SavingsAccount) this.acc1).applyInterest();
        Assert.assertEquals(1010, this.acc1.getAmount(), e);
    }

    @Test
    public void applyInterest2() {
        this.acc1.credit(22950);
        ((SavingsAccount) this.acc1).applyInterest();
        Assert.assertEquals(23179.5, this.acc1.getAmount(), e);
    }

}
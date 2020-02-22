package fr.cnam.nfp121.tp6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BankTest {
    private final static double e = 0.0001;
    String nom0 = "HADDAD";
    String prenom0 = "Nicolas";
    Gender genre0 = Gender.MALE;
    String nom1 = "Toto";
    String prenom1 = "Tutu";
    Gender genre1 = Gender.FEMALE;
    private Bank bnk0;
    private Person p0, p1;

    @Before
    public void setUp() throws Exception {
        this.bnk0 = new Bank();
        this.p0 = new Person(nom0, prenom0, genre0);
        this.p1 = new Person(nom1, prenom1, genre1);
    }

    @Test
    public void testInitialisation() {
        assertNotNull(this.bnk0);
    }

    @Test
    public void openSimpleAccount() {
        this.bnk0.openSimpleAccount(this.p0);
        this.bnk0.openSimpleAccount(this.p1);
        assertEquals(2, this.bnk0.getNbAccounts());
    }

    @Test
    public void openCheckingAccount() {
        this.bnk0.openCheckingAccount(this.p0);
        this.bnk0.openCheckingAccount(this.p1);
        assertEquals(2, this.bnk0.getNbAccounts());
    }

    @Test
    public void getTotalAmounts() {
        this.bnk0.openCheckingAccount(this.p0);
        this.bnk0.openSimpleAccount(this.p1);
        this.bnk0.getAccount(1).credit(100);
        this.bnk0.getAccount(2).debit(25);
        assertEquals(75, this.bnk0.getTotalAmounts(), e);
    }

    @Test
    public void getNbDebitors() {
        this.bnk0.openCheckingAccount(this.p0);
        this.bnk0.openCheckingAccount(this.p1);
        this.bnk0.openSimpleAccount(this.p0);
        this.bnk0.openSimpleAccount(this.p1);
        this.bnk0.getAccount(1).credit(100);
        this.bnk0.getAccount(2).debit(25);
        this.bnk0.getAccount(3).credit(150);
        this.bnk0.getAccount(4).debit(50);
        assertEquals(2, this.bnk0.getNbDebitors());
    }

    @Test
    public void getTotalDebitorsAmounts() {
        this.bnk0.openCheckingAccount(this.p0);
        this.bnk0.openCheckingAccount(this.p1);
        this.bnk0.openSimpleAccount(this.p0);
        this.bnk0.openSimpleAccount(this.p1);
        this.bnk0.getAccount(1).credit(100);
        this.bnk0.getAccount(2).debit(25);
        this.bnk0.getAccount(3).credit(150);
        this.bnk0.getAccount(4).debit(50);
        assertEquals(-75, this.bnk0.getTotalDebitorsAmounts(), e);
    }

    @Test
    public void applyBankFees() {
        this.bnk0.openCheckingAccount(this.p0);
        this.bnk0.openCheckingAccount(this.p1);
        this.bnk0.openSimpleAccount(this.p0);
        this.bnk0.openSimpleAccount(this.p1);
        this.bnk0.getAccount(1).credit(100);
        this.bnk0.getAccount(2).debit(25);
        this.bnk0.getAccount(3).credit(150);
        this.bnk0.getAccount(4).debit(50);
        this.bnk0.applyBankFees();
        assertEquals(100 - 25 + 150 - 50 - 8, this.bnk0.getTotalAmounts(), e);
    }

    @Test
    public void getAllCheckingAccountStatements() {
        this.bnk0.openCheckingAccount(this.p0);
        this.bnk0.openCheckingAccount(this.p1);
        this.bnk0.openSimpleAccount(this.p0);
        this.bnk0.openSimpleAccount(this.p1);
        this.bnk0.getAccount(1).credit(100);
        this.bnk0.getAccount(2).debit(25);
        this.bnk0.getAccount(3).credit(150);
        this.bnk0.getAccount(4).debit(50);
        assertEquals("Bank Accounts List:\n[\n1, 100.0\n]\n[\n1, -25.0\n]\n", this.bnk0.getAllCheckingAccountStatements());
    }
}
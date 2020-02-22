package fr.cnam.nfp121.tp8;


public class TestSimpleAccountAssert {
    public static void main(String[] args) {
        Person p1 = new Person("Jean", "Jean", true);
        SimpleAccount sa1 = null;
        try {
            sa1 = new SimpleAccount(p1, 1000);
        } catch (InitialBalanceException e) {
            e.printStackTrace();
        } catch (InvalidOwnerException e) {
            e.printStackTrace();
        }
        assert true;
        assert sa1.getBalance() == 1000;
        try {
            sa1.credit(100);
        } catch (AmountException e) {
            e.printStackTrace();
        }
        assert sa1.getBalance() == 1100;
        if (sa1.getBalance() >= 2000)
            try {
                sa1.withdraw(2000);
            } catch (AmountException e) {
                e.printStackTrace();
            }
        assert sa1.getBalance() == 1100;

        SimpleAccount sa2 = new SimpleAccount(p1);
        assert sa2.getBalance() == 0;
        try {
            sa2.credit(100);
        } catch (AmountException e) {
            e.printStackTrace();
        }
        assert sa2.getBalance() == 100;
    }
}


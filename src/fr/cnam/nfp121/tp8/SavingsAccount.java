package fr.cnam.nfp121.tp8;


/**
 * ____________________________________________________________________________________________<br
 * NFP121:TP6 <br>
 * Nicolas HADDAD        <br>
 * nicolas.haddad80@gmail.com  <br>
 * ____________________________________________________________________________________________<br
 * La classe SavingsAccount Modelise un Livret A Bancaire  <br>
 * ____________________________________________________________________________________________<br>
 */
public class SavingsAccount {
    /**
     * Constante de classe pour definir le solde maximum que peut atteidre un livret A (Hors interets)
     */
    private static final double MAXAMOUNT = 22950;

    /**
     * Constante de classe pour definir le taux d'interet en vigeure pour un livret A
     */
    private static final double INTERESTRATE = 1;

    /**
     * Attribute to decorate Checking Account
     */

    private CheckingAccount checkingAccount;

    /**
     * Constructeur de notre Livret A
     */
    public SavingsAccount(Person owner) {

        this.checkingAccount = new CheckingAccount(owner);
    }

    /**
     * Methode qui permet de crediter notre Compte Simple d'une somme donnee
     *
     * @param a_Amount : la somme a crediter sur notre Compte Simple
     */


    public void credit(double a_Amount) throws LimitExceededException, AmountException {
        if ((this.checkingAccount.getAmount() + a_Amount) > MAXAMOUNT)
            throw new LimitExceededException();

        this.checkingAccount.credit(a_Amount);
    }

    /**
     * Methode qui permet de debiter une somme donnee de notre Compte Simple
     *
     * @param a_Amount : la somme a debiter de notre Compte Simple
     */

    public void debit(double a_Amount) throws AmountException {
        this.checkingAccount.withdraw((int) a_Amount);
    }

    /**
     * Methode qui permet d'appliquer le taux d'interets a notre Livret A.
     */
    public void applyInterest() {
        try {
            this.checkingAccount.credit(this.checkingAccount.getBalance() * INTERESTRATE / 100);
        } catch (AmountException e) {
            e.printStackTrace();
        }
    }


    /**
     * Methode qui permet d'afficher notre Compte Simple sur la cosol
     *
     * @return : La chaine de caracteres representant notre Compte Simple
     */
    public String toString() {
        return this.checkingAccount.toString();
    }

    /**
     * Methode qui permet d'obtenir le solde de notre Compte Simple
     *
     * @return : Le solde de notre Compte Simple
     */
    public double getAmount() {
        return this.checkingAccount.getAmount();
    }

    /**
     * Methode qui permet d'obtenir le solde de notre Compte Simple
     *
     * @return : Le solde de notre Compte Simple
     */
    public int getBalance() {
        return this.checkingAccount.getBalance();
    }

    /**
     * Methode qui permet d'obtenir le stitulaire de notre Compte Simple
     *
     * @return : Le titulaire de notre Compte Simple
     */
    public Person getOwner() {
        return this.checkingAccount.getOwner();
    }
}
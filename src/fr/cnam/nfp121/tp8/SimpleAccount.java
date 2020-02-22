package fr.cnam.nfp121.tp8;


/**
 * ___________________________________________________________<br>
 * NFP121:TP6 <br>
 * Nicolas HADDAD        <br>
 * nicolas.haddad80@gmail.com  <br>
 * _____________________________________________________________<br>
 * La classe SimpleAccount Modelise un Compte Bancaire Simple <br>
 * La modelisation d'un Compte Simple  est represente par la Personne qui le detient et son Solde courant  dans deux attribus <br>
 * ____________________________________________________________________________________<br>
 */

public class SimpleAccount {

    /**
     * Le Propritaire de  Compte Simple
     */
    protected Person owner;

    /**
     * Le solde de notre Compte Simple
     */
    protected double solde;

    /**
     * Constructeur de notre Compte Simple (solde initial mis  a zero)
     */


    public SimpleAccount(Person p1, int i) throws InitialBalanceException, InvalidOwnerException {
        if (p1 == null)
            throw new InvalidOwnerException();
        else if (i < 0)
            throw new InitialBalanceException();
        else {
            this.solde = i;
            this.owner = p1;
        }
    }

    /**
     * Constructeur de notre Compte Simple (solde initial mis  a zero)
     *
     * @param a_Owner : La Personne propritaire de notre Compte Simple
     */
    public SimpleAccount(Person a_Owner) {
        this.owner = a_Owner;
        this.solde = 0;
    }

    /**
     * Methode qui permet de crediter notre Compte Simple d'une somme donnee
     *
     * @param a_Amount : la somme a crediter sur notre Compte Simple
     */
    public void credit(double a_Amount) throws AmountException {
        if (a_Amount < 0)
            throw new AmountException("Le Credit a depose doit etre strictement positif", (int) Math.round(this.solde));
        else
            this.solde += a_Amount;
    }

    /**
     * Methode qui permet de debiter une somme donnee de notre Compte Simple
     *
     * @param a_Amount : la somme a debiter de notre Compte Simple
     */
    public void debit(double a_Amount) {
        this.solde -= a_Amount;
    }

    public void withdraw(int a_Amount) throws AmountException {
        if (this.solde < a_Amount)
            throw new AmountException("Solde insuffisant pour ce retrait", a_Amount);

        this.solde -= a_Amount;
    }

    /**
     * Methode qui permet d'afficher notre Compte Simple sur la cosol
     *
     * @return : La chaine de caracteres representant notre Compte Simple
     */
    public String toString() {
        return "[" + this.owner.toString() + ", " + this.solde + "]";
    }

    /**
     * Methode qui permet d'obtenir le solde de notre Compte Simple
     *
     * @return : Le solde de notre Compte Simple
     */
    public double getAmount() {
        return this.solde;
    }

    /**
     * Methode qui permet d'obtenir le solde de notre Compte Simple
     *
     * @return : Le solde de notre Compte Simple
     */
    public int getBalance() {
        return (int) Math.round(this.solde);
    }

    /**
     * Methode qui permet d'obtenir le stitulaire de notre Compte Simple
     *
     * @return : Le titulaire de notre Compte Simple
     */
    public Person getOwner() {
        return this.owner;
    }

}
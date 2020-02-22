package fr.cnam.nfp121.tp6;

/**
 * ____________________________________________________________________________________________<br
 * NFP121:TP6 <br>
 * Nicolas HADDAD        <br>
 * nicolas.haddad80@gmail.com  <br>
 * ____________________________________________________________________________________________<br
 * La classe SavingsAccount Modelise un Livret A Bancaire  <br>
 * ____________________________________________________________________________________________<br>
 */
public class SavingsAccount extends CheckingAccount {
    /**
     * Constante de classe pour definir le solde maximum que peut atteidre un livret A (Hors interets)
     */
    private static final double MAXAMOUNT = 22950;

    /**
     * Constante de classe pour definir le taux d'interet en vigeure pour un livret A
     */
    private static final double INTERESTRATE = 1;

    /**
     * Constructeur de notre Livret A
     *
     * @param a_Owner : La Personne titulaire du Livret A
     */
    public SavingsAccount(Person a_Owner) {
        super(a_Owner);
    }

    /**
     * Methode qui permet de crediter notre Compte Simple d'une somme donnee
     *
     * @param a_Amount : la somme a crediter sur notre Compte Simple
     */

    @Override
    public void credit(double a_Amount) {
        assert (this.getAmount() + a_Amount) <= MAXAMOUNT : "Cannot Credit this Amount due to Maximum Amount will not be respected";
        // if ((this.getAmount() + a_Amount) <= MAXAMOUNT){
        super.credit(a_Amount);
  /*  }
    else {
      System.out.println("Cannot Credit this Amount due to Maximum Amount will not be respected");
    }*/
    }

    /**
     * Methode qui permet de debiter une somme donnee de notre Compte Simple
     *
     * @param a_Amount : la somme a debiter de notre Compte Simple
     */

    @Override
    public void debit(double a_Amount) {
        assert this.getAmount() - a_Amount >= 0 : "No enough Credit";
        //  if(this.getAmount()-a_Amount>=0){
        super.debit(a_Amount);
   /* }
    else {
      System.out.println("No enough Credit");
    }*/
    }

    /**
     * Methode qui permet d'appliquer le taux d'interets a notre Livret A.
     */
    public void applyInterest() {
        this.solde += this.solde * INTERESTRATE / 100;
    }
}
package tp6;

/**
 * ____________________________________________________________________________________________<br
 * NFP121:TP6 <br>
 * Nicolas HADDAD        <br>
 * nicolas.haddad80@gmail.com  <br>
 * ____________________________________________________________________________________________<br
 * La classe CheligAccount Modelise un Compte Courant Bancaire  <br>
 * La modelisation d'un Compte Courant est represente par un Compte Simple et son Historique d'operation dans un attribu <br>
 * ____________________________________________________________________________________________<br>
 */
public class CheckingAccount extends SimpleAccount {

    /**
     * L'historique de notre Compte Courant
     */
    protected History accountStatement;

    /**
     * Constructeur de notre Compte Courant
     *
     * @param a_Owner : La Personne titulaire du Compte Courant
     */
    public CheckingAccount(Person a_Owner) {
        super(a_Owner);
        this.accountStatement = new History();
    }

    /**
     * Methode qui permet d'avoir une chaine de caracteres representant tous l'historque de notre Compte Courant
     *
     * @ return : La chaine de caracteres representant tous l'historque de notre Compte Courant
     */
    public String getAccountStatement() {
        return this.accountStatement.toString();
    }

    /**
     * Methode qui permet d'avoir une chaine de caracteres representant  l'historque de tous les Credits de notre Compte Courant
     *
     * @ return : La chaine de caracteres representant  l'historque de tous les credits de notre Compte Courant
     */
    public String getCreditStatement() {
        return this.accountStatement.getCredit().toString();
    }

    /**
     * Methode qui permet d'avoir une chaine de caracteres representant  l'historque de tous les debits de notre Compte Courant
     *
     * @ return : La chaine de caracteres representant  l'historque de tous les debits de notre Compte Courant
     */
    public String getDebitStatement() {
        return this.accountStatement.getDebit().toString();
    }

    /**
     * Methode qui permet de crediter notre Compte Simple d'une somme donnee
     *
     * @param a_Amount : la somme a crediter sur notre Compte Simple
     */
    @Override
    public void credit(double a_Amount) {
        super.credit(a_Amount);
        this.accountStatement.addOperation(a_Amount);
    }

    /**
     * Methode qui permet de debiter une somme donnee de notre Compte Simple
     *
     * @param a_Amount : la somme a debiter de notre Compte Simple
     */
    @Override
    public void debit(double a_Amount) {
        super.debit(a_Amount);
        this.accountStatement.addOperation(-a_Amount);
    }
}
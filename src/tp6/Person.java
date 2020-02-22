package tp6;

/**
 * ___________________________________________________________<br>
 * NFP121:TP6 <br>
 * Nicolas HADDAD        <br>
 * nicolas.haddad80@gmail.com  <br>
 * _____________________________________________________________<br>
 * La classe Person Modelise une Personne <br>
 * La modelisation d'une Personne  est represente par son Nom, son Prenom et son genre (sexe) dans trois attribus <br>
 * ____________________________________________________________________________________<br>
 */

public class Person {

    /**
     * Le Nom de notre Personne
     */
    private String nom;

    /**
     * Le Prenom de notre Personne
     */
    private String prenom;

    /**
     * Le Sexe de notre Personne
     */
    private Gender genre;

    /**
     * Constructeur de Notre Personne
     *
     * @param a_Nom    : Le Nom de notre Personne
     * @param a_Prenom : Le prenom de notre Personne
     * @param a_Genre  : Le Sexe de notre Personne
     */
    public Person(String a_Nom, String a_Prenom, Gender a_Genre) {
        this.nom = a_Nom;
        this.prenom = a_Prenom;
        this.genre = a_Genre;
    }

    /**
     * Methode qui permet d'afficher notre Personne sur la cosol
     *
     * @return : La chaine de caracteres representant notre Person
     */
    public String toString() {
        return "(" + this.nom + ", " + this.prenom + ", " + this.genre + ")";
    }
}
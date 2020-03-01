package fr.cnam.nfp121.exercicescours1;

/**
 * ___________________________________________________________<br>
 * NFP121 <br>
 * <p>
 * Cours1:Exercice 1 Fractions           <br>
 * <p>
 * Nicolas HADDAD        <br>
 * nicolas.haddad80@gmail.com  <br>
 * _____________________________________________________________<br>
 * <p>
 * <p>
 * La classe Fraction Modélise les Fractions mathématiques (ensemble Q) <br>
 * La modèlisation d'une fraction est représenté par son numérateur et son dénominateur dans deux attribus <br>
 * cette classe implémente les opérations suivantes: inverstion du signe de la fraction, addition d'une fraction, addition d'un entier, l'initilaisation et l'affichage
 *
 * @author Nicolas HADDAD
 * @version 1.0
 */


public class Fraction {

    /****************************************
     Les attribus de la classe Fraction
     ****************************************/

    //numérateur de la Fraction
    int num;
    // Dénominateur de la Fracion
    int denom;


    /****************************************
     Les méthodes de la classe Fraction
     ****************************************/


    /*___________________________________________________________*/

    /**
     * Main pour les tests unitaires de la classe  Fraction <br>
     * Elle permet d'exercer les 4 Usecaces modèlisés dans le Diagramme de Use Case UML <br>
     * Elle permet aussi de tester la redéfinition de la fonction toString() d'affichage héritée de la classe mère Objet.
     */

    public static void main(String[] args) {
        /*Déclaration de deux poignés  Fraction*/
        Fraction f1, f2;
        /*instanciation (Création) des deux objets Fraction et affectation aux deux poignées respectivement*/

        f1 = new Fraction();
        f2 = new Fraction();

        /*Initilaisation des deux objets Fraction (On supposera que l'utilisateur est assez intéligeant pour ne pas donner '0' comme denoménateur */

        f1.init(5, 3);
        f2.init(7, 9);

        /*affichage des deux Fractions afin de vérifier le bon focntionnement de la Méthode init() et en même temps de la méthode redéfinie toString()*/

        System.out.println("f1=" + f1);
        System.out.println("f2=" + f2);

        /* Test unitaire de la méthode invert() d'inversion du signe de la Fraction f1 , Usecase : inverser  -referez vous au diagramme de cas d'utilisation*/
        System.out.print("L'inversion du signe de f1=" + f1 + " donne: ");
        f1.invert();

        /*affichage pour vérifier l'inversion du signe et que toString() est capable d'afficher 	le signe "-"*/
        System.out.println("f1=" + f1);


        /*Test unitaire de la méthode add d'une fraction méthode add(f:Fraction), Usecase : Ajouter Fraction  -referez vous au diagramme de cas d'utilisation*/
        System.out.print("L'addition de f1=" + f1 + " et f2=" + f2 + " donne: ");
        f1.add(f2);
        /*affichage pour vérifier l'ajout*/
        System.out.println("f1=" + f1);


        /*Test unitaire de la méthode add d'un entier méthode add(ent:entier),  Usecase : Ajouter Entier  -referez vous au Diagramme de Cas d'Utilisation*/
        int nombre = 4;
        System.out.print("L'addition de f2=" + f2 + " et " + nombre + " donne: ");
        f2.add(4);
        /*affichage pour vérifier l'ajout*/
        System.out.println(f2);


    }





    /*___________________________________________________________*/

    /**
     * Méthode pour initialiser notre Fraction
     *
     * @param a_num   Le Numérateur de notre Fraction
     * @param a_denom Le Dénomionateur de notre Fraction.
     */

    public void init(int a_num, int a_denom) {

        this.num = a_num;
        this.denom = a_denom;
    }




    /*___________________________________________________________*/

    /**
     * Méthode pour inverser le signe de notre Fraction
     */
    public void invert() {
        this.num = this.num * (-1);
    }




    /*___________________________________________________________*/

    /**
     * Méthode pour additionner une fraction à notre Fraction
     *
     * @param a_f La fraction a rajouter à notre Fraction
     */
    public void add(Fraction a_f) {
        //rappel mathématique: A/B + C/D = A*D+C*B / B*D)
        this.num = this.num * a_f.denom + a_f.num * this.denom;
        this.denom = this.denom * a_f.denom;
    }




    /*___________________________________________________________*/

    /**
     * Méthode pour additionner un entier à notre Fraction
     *
     * @param a_ent L'entier a rajouter à notre Fraction
     */
    public void add(int a_ent) {
        //rappel mathématique: A/B+C= A+CB/B
        this.num = this.num + a_ent * this.denom;
    }

    /*=====================================================================================================*/

    /**
     * Méthode pour afficher notre Fraction
     *
     * @return La chaine de caractères représentant notre Fraction
     */
    public String toString() {
        return this.num + "/" + this.denom;
    }
}

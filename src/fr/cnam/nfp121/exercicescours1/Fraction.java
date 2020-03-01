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
 * La classe Fraction Mod�lise les Fractions math�matiques (ensemble Q) <br>
 * La mod�lisation d'une fraction est repr�sent� par son num�rateur et son d�nominateur dans deux attribus <br>
 * cette classe impl�mente les op�rations suivantes: inverstion du signe de la fraction, addition d'une fraction, addition d'un entier, l'initilaisation et l'affichage
 *
 * @author Nicolas HADDAD
 * @version 1.0
 */


public class Fraction {

    /****************************************
     Les attribus de la classe Fraction
     ****************************************/

    //num�rateur de la Fraction
    int num;
    // D�nominateur de la Fracion
    int denom;


    /****************************************
     Les m�thodes de la classe Fraction
     ****************************************/


    /*___________________________________________________________*/

    /**
     * Main pour les tests unitaires de la classe  Fraction <br>
     * Elle permet d'exercer les 4 Usecaces mod�lis�s dans le Diagramme de Use Case UML <br>
     * Elle permet aussi de tester la red�finition de la fonction toString() d'affichage h�rit�e de la classe m�re Objet.
     */

    public static void main(String[] args) {
        /*D�claration de deux poign�s  Fraction*/
        Fraction f1, f2;
        /*instanciation (Cr�ation) des deux objets Fraction et affectation aux deux poign�es respectivement*/

        f1 = new Fraction();
        f2 = new Fraction();

        /*Initilaisation des deux objets Fraction (On supposera que l'utilisateur est assez int�ligeant pour ne pas donner '0' comme denom�nateur */

        f1.init(5, 3);
        f2.init(7, 9);

        /*affichage des deux Fractions afin de v�rifier le bon focntionnement de la M�thode init() et en m�me temps de la m�thode red�finie toString()*/

        System.out.println("f1=" + f1);
        System.out.println("f2=" + f2);

        /* Test unitaire de la m�thode invert() d'inversion du signe de la Fraction f1 , Usecase : inverser  -referez vous au diagramme de cas d'utilisation*/
        System.out.print("L'inversion du signe de f1=" + f1 + " donne: ");
        f1.invert();

        /*affichage pour v�rifier l'inversion du signe et que toString() est capable d'afficher 	le signe "-"*/
        System.out.println("f1=" + f1);


        /*Test unitaire de la m�thode add d'une fraction m�thode add(f:Fraction), Usecase : Ajouter Fraction  -referez vous au diagramme de cas d'utilisation*/
        System.out.print("L'addition de f1=" + f1 + " et f2=" + f2 + " donne: ");
        f1.add(f2);
        /*affichage pour v�rifier l'ajout*/
        System.out.println("f1=" + f1);


        /*Test unitaire de la m�thode add d'un entier m�thode add(ent:entier),  Usecase : Ajouter Entier  -referez vous au Diagramme de Cas d'Utilisation*/
        int nombre = 4;
        System.out.print("L'addition de f2=" + f2 + " et " + nombre + " donne: ");
        f2.add(4);
        /*affichage pour v�rifier l'ajout*/
        System.out.println(f2);


    }





    /*___________________________________________________________*/

    /**
     * M�thode pour initialiser notre Fraction
     *
     * @param a_num   Le Num�rateur de notre Fraction
     * @param a_denom Le D�nomionateur de notre Fraction.
     */

    public void init(int a_num, int a_denom) {

        this.num = a_num;
        this.denom = a_denom;
    }




    /*___________________________________________________________*/

    /**
     * M�thode pour inverser le signe de notre Fraction
     */
    public void invert() {
        this.num = this.num * (-1);
    }




    /*___________________________________________________________*/

    /**
     * M�thode pour additionner une fraction � notre Fraction
     *
     * @param a_f La fraction a rajouter � notre Fraction
     */
    public void add(Fraction a_f) {
        //rappel math�matique: A/B + C/D = A*D+C*B / B*D)
        this.num = this.num * a_f.denom + a_f.num * this.denom;
        this.denom = this.denom * a_f.denom;
    }




    /*___________________________________________________________*/

    /**
     * M�thode pour additionner un entier � notre Fraction
     *
     * @param a_ent L'entier a rajouter � notre Fraction
     */
    public void add(int a_ent) {
        //rappel math�matique: A/B+C= A+CB/B
        this.num = this.num + a_ent * this.denom;
    }

    /*=====================================================================================================*/

    /**
     * M�thode pour afficher notre Fraction
     *
     * @return La chaine de caract�res repr�sentant notre Fraction
     */
    public String toString() {
        return this.num + "/" + this.denom;
    }
}

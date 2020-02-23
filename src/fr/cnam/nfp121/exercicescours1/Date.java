package fr.cnam.nfp121.exercicescours1;

/**
 * ___________________________________________________________<br>
 * NFP121 <br>
 * <p>
 * Cours1:Exercice 2 les Dates           <br>
 * <p>
 * Nicolas HADDAD        <br>
 * nicolas.haddad80@gmail.com  <br>
 * _____________________________________________________________<br>
 * <p>
 * <p>
 * Cette classe mod�lise les Dates d'un calendrier suppos� avoir 30 jours par mois quelque soit le mois <br>
 * La mod�lisation d'une date est repr�sent� par son jour, son mois et son ann�e dans trois attribus <br>
 * cette classe impl�mente les op�rations suivantes: getDay,getMonth,getYear,compare,incremente, l'initilaisation et l'affichage
 *
 * @author Nicolas HADDAD
 * @version 1.0
 */
public class Date {

    //****************************************
    // Les attribus de la classe Fraction
    //****************************************

    /**
     * le jour de la date
     */
    public int day;

    /**
     * Le mois de la date
     */
    public int month;

    /**
     * l'ann�e de la date
     */
    public int year;

    //****************************************
    // Le constructeur
    //****************************************

    //___________________________________________________________

    /**
     * constructeur de notre Date
     *
     * @param a_day   Le jour de la Date
     * @param a_month Le mois de la Date
     * @param a_year  L'ann�e de la Date
     */
    public Date(int a_day, int a_month, int a_year) {
        this.day = a_day;
        this.month = a_month;
        this.year = a_year;
    }

    //****************************************
    // Les m�thodes de la classe Fraction
    //****************************************


    //___________________________________________________________

    /**
     * Main pour les tests unitaires de la classe  Date <br>
     *
     * @param args[] No Idea what is this
     */

    public static void main(String[] args) {
        Date d1, d2, d3, d4, d5;
	 /* d1=new Date();
	  d1.init(3,5,2019);

	  d2=new Date();
	  d2.init(11,10,2019);

	  d3=new Date();
	  d3.init(30,10,999);

	  d4=new Date();
	  d4.init(30,12,99);

	  d5=new Date();
	  d5.init(11,10,9);
	  */
        d1 = new Date(3, 5, 2019);
        d2 = new Date(11, 10, 2019);
        d3 = new Date(30, 10, 999);
        d4 = new Date(30, 12, 99);
        d5 = new Date(11, 10, 9);


        System.out.println("d1=" + d1);
        System.out.println("d2=" + d2);
        System.out.println("d3=" + d3);
        System.out.println("d4=" + d4);
        System.out.println("d5=" + d5);
        System.out.println("d1 Day=" + d1.getDay());
        System.out.println("d1 Month=" + d1.getMonth());
        System.out.println("d1 Year=" + d1.getYear());
        System.out.println("Compare d1 to d2 result=" + d1.compare(d2));
        System.out.println("Compare d2 to d1 result=" + d2.compare(d1));
        System.out.println("Compare d1 to d1 result=" + d1.compare(d1));

        d2.increment();
        System.out.println("Increment d2=" + d2);

        d3.increment();
        System.out.println("Increment d3=" + d3);

        d4.increment();
        System.out.println("Increment d4=" + d4);

        d5.addDuration(394);
        System.out.println("d5 + 394=" + d5);


    }


    //___________________________________________________________

    /**
     * M�thode pour initialiser notre Date
     *
     * @param a_day   Le jour de la Date
     * @param a_month Le mois de la Date
     * @param a_year  L'ann�e de la Date
     * @deprecated use Constructor instead.
     */
    @Deprecated
    public void init(int a_day, int a_month, int a_year) {
        this.day = a_day;
        this.month = a_month;
        this.year = a_year;
    }


    //___________________________________________________________

    /**
     * M�thode pour obtenir le jour de notre Date
     *
     * @return Le jour de notre Date
     */
    public int getDay() {
        return this.day;
    }


    //___________________________________________________________

    /**
     * M�thode pour obtenir le mois de notre Date
     *
     * @return Le mois de notre Date
     */
    public int getMonth() {
        return this.month;
    }


    //___________________________________________________________

    /**
     * M�thode pour obtenir l'ann�e de notre Date
     *
     * @return L'ann�e de notre Date
     */
    public int getYear() {
        return this.year;
    }


    //___________________________________________________________

    /**
     * M�thode pour afficher notre Date
     *
     * @return La chaine de caract�res repr�sentant notre Date
     */
    public String toString() {
        String prefDay = "";
        String prefMonth = "";
        String prefYear = "";


        if (this.day < 10) {
            prefDay = "0";
        }
        if (this.month < 10) {
            prefMonth = "0";
        }
        if (this.year < 1000) {
            prefYear = "0";
        }
        if (this.year < 100) {
            prefYear = "00";
        }
        if (this.year < 10) {
            prefYear = "000";
        }


        return prefDay + this.day + "/" + prefMonth + this.month + "/" + prefYear + this.year;
    }


    //___________________________________________________________

    /**
     * M�thode pour comparer notre Date � une autre Date donn�e
     *
     * @param a_date La Date � laquelle on veut comparer notre Date
     * @return entier strictement n�gatif si notre date pr�c�de la Date donn�e,
     * entier strictement positif si notre date est apr�s la Date donn�e,
     * l'entier null (0) si notre Date est �gale � la Date donn�e
     */
    public int compare(Date a_date) {
        return (this.day + this.month * 30 + this.year * 12 * 30) - (a_date.getDay() + a_date.getMonth() * 30 + a_date.getYear() * 12 * 30);
    }


    //___________________________________________________________

    /**
     * M�thode pour incr�menter notre Date d'un jour
     */
    public void increment() {

        this.day = this.day + 1;


        if (this.day > 30) {

            this.day = 1;
            this.month = this.month + 1;
            if (this.month > 12) {
                this.month = 1;
                this.year = this.year + 1;
            }
        }

    }

    //=====================================================================================================

    /**
     * M�thode pour ajouter une duree a notre Date
     *
     * @param a_duration La duree a rajouter a notre date
     */
    public void addDuration(int a_duration) {


        for (int i = 0; i < a_duration; i++) {
            this.increment();
        }
    }
}

package fr.cnam.tp1and2.point;
/** 
 *  ___________________________________________________________<br>
 *                         NFP121:TP2 <br>                          
 *  Nicolas HADDAD        <br>                              
 *  nicolas.haddad80@gmail.com  <br>
 *  _____________________________________________________________<br>                               
 *   La classe Point Modelise u point geometrique dans un plan 2D <br>
 *   La modelisation d'un Point  est represente par son Abscisse X et son ordonnee Y dans deux attribus <br>
 *  ____________________________________________________________________________________<br>
 */
public class Point {
  /* {version=1.0, author= Nicolas HADDAD}*/


  /**
   * L'Abscisse de notre Point
   */
  private double x;

  /**
   * L'Ordonnee de notre Point
   */
  private double y;


  /**
   * Le constructeur de notre Point
   *
   * @param a_x : L'Abscisse de notre Point
   * @param a_y : L'Ordonnee de notre Point
   */
  public Point(double a_x, double a_y) {
    this.x = a_x;
    this.y = a_y;
  }

  /**
   * Mise a jour de l'Abscisse de notre Point
   *
   * @param a_x : La nouvelle Abscisse de notre Point
   */
  public void setX(double a_x) {
    this.x = a_x;
  }

  /**
   * Mise a jour de l'Ordonnee de notre Point
   *
   * @param a_y : La nouvelle Ordonnee de notre Point
   */
  public void setY(double a_y) {
    this.y = a_y;
  }

  /**
   * Mise a jour du Module de notre Point
   *
   * @param a_mod : Le nouveau Module de notre Point
   */
  public void setMod(double a_mod) {
    this.x = a_mod * Math.cos(this.getArg());
    this.y = a_mod * Math.sin(this.getArg());
  }

  /**
   * Mise a jour de l'Argument de notre Point
   *
   * @param a_arg : Le nouveau Argument e de notre Point
   */
  public void setArg(double a_arg) {
    this.x = this.getMod() * Math.cos(a_arg);
    this.y = this.getMod() * Math.sin(a_arg);
  }

  /**
   * Pour obtenir l'Abscisse de Notre Point
   *
   * @return : L'Abscisse de notre Point
   */
  public double getX() {
    return this.x;
  }

  /**
   * Pour obtenir l'Ordonnee de Notre Point
   *
   * @return : L'Ordonnee de notre Point
   */
  public double getY() {
    return this.y;
  }

  /**
   * Pour obtenir l'Argument de Notre Point
   *
   * @return : L'Argument de notre Point
   */
  public double getArg() {
    double tempArg;
    if (this.getArg() != 0) {
      tempArg = Math.asin(this.y / this.getMod());
    } else {
      tempArg = 0;
    }
    return tempArg;
  }

  /**
   * Pour obtenir le Module de Notre Point
   *
   * @return : le Module de notre Point
   */
  public double getMod() {
    return Math.sqrt(this.x * this.x + this.y * this.y);
  }

  /**
   * Pour appliquer une translation a notre Point
   *
   * @param a_x : le deplacement a appliquer selon l'axe de Abscisses
   * @param a_y : le deplacement a appliquer selon l'axe des Ordonnees
   */
  public void translate(double a_x, double a_y) {
    this.x = this.x + a_x;
    this.y = this.y + a_y;
  }

  /**
   * Permet de calculer la distance separant notre point  par rapport a un autre Point de reference
   *
   * @param a_p : le point de reference
   * @return : la distance entre notre Point  et le Point de reference
   */
  public double distance(Point a_p) {
    return (Math.sqrt((a_p.getX() - this.x) * (a_p.getX() - this.x) + (a_p.getY() - this.y) * (a_p.getY() - this.y)));
  }

  /**
   * Representation de notre Point sous forme d'une chaine de caracteres
   *
   * @return : La chaine de caracteres representant notre Point
   */
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}


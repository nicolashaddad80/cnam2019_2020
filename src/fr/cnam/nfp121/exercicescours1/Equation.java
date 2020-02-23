package fr.cnam.nfp121.exercicescours1;

public class Equation {

    double coeffA, coeffB, coeffC;
    double x1, x2;


    public Equation(double a_coeffA, double a_coeffB, double a_coeffC) {
        this.coeffA = a_coeffA;
        this.coeffB = a_coeffB;
        this.coeffC = a_coeffC;

    }

    public Equation(double somme, double produit) {
        this(1, -somme, produit);
    }


    public void solve() {
        double delta;
        delta = (this.coeffB) * (this.coeffB) - 4 * this.coeffA * this.coeffC;

        this.x1 = (-this.coeffB - java.lang.Math.sqrt(delta)) / (2 * this.coeffA);
        this.x2 = (-this.coeffB + java.lang.Math.sqrt(delta)) / (2 * this.coeffA);


    }

    public double getRoot1() {

        return this.x1;
    }

    public double getRoot2() {

        return this.x2;
    }

    public String toString() {
        return (this.coeffA + "*x2 + "
                + this.coeffB + "*x + "
                + this.coeffC + " = 0");

    }


}
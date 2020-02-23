package fr.cnam.nfp121.exercicescours1;

public class SolveEquation {


    public static void main(String[] args) {


        Equation eq1;
        eq1 = new Equation(1, 5, 6);

        System.out.println(eq1);

        eq1.solve();

        System.out.println("Racine 1 = " + eq1.getRoot1());

        System.out.println("Racine 2 = " + eq1.getRoot2());


    }

}
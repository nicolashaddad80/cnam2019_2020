package fr.cnam.nfp121.tp8;

import java.util.Scanner;

public class UserIntReader {

    public static int nextInt(String message) {
        String sNumber = null;
        Scanner scanner = null;
        int intNumber;
        System.out.println(message);
        System.out.flush();
        scanner = new Scanner(System.in);
        sNumber = scanner.nextLine();
        return Integer.parseInt(sNumber);
    }

    public static void main(String[] args) {

        int n = 0;
        String message1 = "Entrez un Nombre Entier:";
        String message2 = "Il faut entrez un Nombre Entier svp";
        boolean success = false;
        while (!success) {
            try {
                n = nextInt(message1);
                success = true;
                System.out.println("You entered : " + n);
            } catch (NumberFormatException e) {
                System.out.println(message2);
            }
        }
    }
}

package fr.cnam.smb111.cours02.tp2_3;

import fr.cnam.nfp121.tp9.menu.specification.Entry;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuImpl implements Menu{
    @Override
    public void printMenu() {
        System.out.println("======================================");
        System.out.println("|        Counter Client Menu          |");
        System.out.println("======================================");
        System.out.println("1- Increment My Server Counter        |");
        System.out.println("2- Decrement My Server Counter        |");
        System.out.println("3- Display My Server Counter          |");
        System.out.println("4- Quit                               |");
        System.out.println("======================================");
    }

    @Override
    public String chooseCommand() {

        System.out.println("Veuillez choisir la commande :");
        boolean ok = false;
        int choix = 0;
        String command = "Unknown";
        Scanner scanner = new Scanner(System.in);


        while (!ok) {

            try {
                choix = scanner.nextInt();
                if (choix >= 1 && choix <= 4)
                    ok = true;
            } catch (InputMismatchException e) {
                try {
                    scanner.nextLine();
                    System.out.println("Il faut choisir un numero valide:");

                } catch (Exception e1) {
                    System.out.println("Erreur de lecrure ");
                    System.exit(-1);
                }
            }
            if(!ok)
                System.out.println("Il faut choisir un numero valide:");
        }

        switch (choix) {
            case 1:
                command = ClientParameters.UP;
                break;
            case 2:
                command = ClientParameters.DOWN;
                break;
            case 3:
                command = ClientParameters.GET;
                break;
            case 4:
                command = ClientParameters.END;
                break;

            default:
                System.err.println("Uknown Command From menu");
                System.exit(-1);
                break;
        }
        return command;
    }
}

